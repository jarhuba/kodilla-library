package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.RentalBook;
import com.kodilla.kodillalibrary.domain.dto.AvaiableBooksNumberDto;
import com.kodilla.kodillalibrary.domain.dto.BookDto;
import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import com.kodilla.kodillalibrary.domain.dto.UserDto;
import com.kodilla.kodillalibrary.mapper.*;
import com.kodilla.kodillalibrary.services.RentBookService;
import com.kodilla.kodillalibrary.services.db.BookDbService;
import com.kodilla.kodillalibrary.services.db.RentalBookDbService;
import com.kodilla.kodillalibrary.services.db.TitleDbService;
import com.kodilla.kodillalibrary.services.db.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/lib")
public class LibraryController {

    @Autowired
    private BookDbService bookDbService;
    @Autowired
    private TitleDbService titleDbService;
    @Autowired
    private RentalBookDbService rentalBookDbService;
    @Autowired
    private UserDbService userDbService;
    @Autowired
    private RentBookService rentBookService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RentalBookMapper rentalBookMapper;
    @Autowired
    private AvaiableBookNumberMapper avaiableBookNumberMapper;

    @GetMapping("addUser")
    public void saveUser(@RequestBody UserDto userDto) {
        userDbService.saveUser(userMapper.mapToUser(userDto));
    }

    @GetMapping("addTitle")
    public void saveTitle(@RequestBody TitleDto titleDto) {
        titleDbService.saveTitle(titleMapper.mapToTitle(titleDto));
    }

    @GetMapping("addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        bookDbService.saveBook(bookMapper.mapToBook(bookDto));
    }

    @PutMapping("updateBookStatus")
    public BookDto updateBookStatus(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookDbService.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping("getAvaiableBooksNumber")
    public AvaiableBooksNumberDto getAvaiableBooksNumber(@RequestBody BookDto bookDto) {
        return avaiableBookNumberMapper.mapToAvaiableBooksNumberDto(bookDbService.getAvaiableBooks(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping("rentBook")
    public RentalBook rentBook(UserDto userDto, TitleDto titleDto) {
        return rentBookService(titleMapper.mapToTitle(titleDto), userMapper.mapToUser(userDto));
    }

//    dodanie czytelnika,
//    dodanie tytułu,
//    dodanie egzemplarza,
//    zmiana statusu egzemplarza,
//    sprawdzenie ilości egzemplarzy danego tytułu dostępnych do wypożyczenia,
//    wypożyczenie książki,
//    zwrot książki.
}
