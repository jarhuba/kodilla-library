package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.controller.exception.RentalNotFoundException;
import com.kodilla.kodillalibrary.domain.dto.BookDto;
import com.kodilla.kodillalibrary.domain.dto.RentDto;
import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import com.kodilla.kodillalibrary.domain.dto.UserDto;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.mapper.RentMapper;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.mapper.UserMapper;
import com.kodilla.kodillalibrary.services.RentService;
import com.kodilla.kodillalibrary.services.db.RentDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rental")
public class RentController {

    @Autowired
    private RentService rentService;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private RentDbService rentDbService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private UserMapper userMapper;



    @PostMapping("rentTitle")
    public RentDto rentBook(@RequestBody TitleDto titleDto, @RequestBody UserDto userDto) throws Exception {
        return rentMapper.mapToRentalDto(rentService.rentTitle(titleMapper.mapToTitle(titleDto), userMapper.mapToUser(userDto)));
    }

    @PostMapping("returnBook")
    public RentDto returnBook(BookDto bookDto) throws RentalNotFoundException {
        return rentMapper.mapToRentalDto(rentService.returnBook(bookMapper.mapToBook(bookDto).getBookUuid()));
    }

    @GetMapping("showAllRentals")
    public List<RentDto> returnAllRentals() {
        return rentMapper.mapToRentalListDto(rentDbService.getAllRentals());
    }
}
