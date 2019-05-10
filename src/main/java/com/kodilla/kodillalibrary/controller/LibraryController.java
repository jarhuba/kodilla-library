package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.dto.BookDto;
import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import com.kodilla.kodillalibrary.domain.dto.UserDto;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.mapper.UserMapper;
import com.kodilla.kodillalibrary.services.BookDbService;
import com.kodilla.kodillalibrary.services.BookRentalDbService;
import com.kodilla.kodillalibrary.services.TitleDbService;
import com.kodilla.kodillalibrary.services.UserDbService;
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
    private BookRentalDbService bookRentalDbService;
    @Autowired
    private UserDbService userDbService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private BookMapper bookMapper;

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




//    dodanie czytelnika,
//    dodanie tytułu,
//    dodanie egzemplarza,
//    zmiana statusu egzemplarza,
//    sprawdzenie ilości egzemplarzy danego tytułu dostępnych do wypożyczenia,
//    wypożyczenie książki,
//    zwrot książki.
}
