package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.controller.exception.RentalNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.dto.RentalDto;
import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import com.kodilla.kodillalibrary.domain.dto.UserDto;
import com.kodilla.kodillalibrary.mapper.RentalMapper;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.mapper.UserMapper;
import com.kodilla.kodillalibrary.services.RentService;
import com.kodilla.kodillalibrary.services.db.RentalDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rental")
public class RentalController {

    @Autowired
    private RentService rentService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private RentalDbService rentalDbService;
    @Autowired
    private RentalMapper rentalMapper;

    @PostMapping("rentBook")
    public Rental rentBook(@RequestParam Long userId, @RequestParam Long titleId) throws Exception {
        return rentService.rentBook(titleId,userId);
    }

    @PostMapping("returnBook")
    public Rental returnBook(Book book) throws RentalNotFoundException {
        return rentService.returnBook(book);
    }

    @GetMapping("showAllRentals")
    public List<RentalDto> returnAllRentals() {
        return rentalMapper.mapToBookRentalListDto(rentalDbService.getAllRentals());
    }
}
