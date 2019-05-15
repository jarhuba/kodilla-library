package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.controller.exception.BookNotFoundException;
import com.kodilla.kodillalibrary.domain.dto.AvaiableBooksNumberDto;
import com.kodilla.kodillalibrary.domain.dto.BookDto;
import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import com.kodilla.kodillalibrary.mapper.AvaiableBookNumberMapper;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.services.db.BookDbService;
import com.kodilla.kodillalibrary.services.db.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookDbService bookDbService;
    @Autowired
    private AvaiableBookNumberMapper avaiableBookNumberMapper;
    @Autowired
    private TitleDbService titleDbService;
    @Autowired
    private TitleMapper titleMapper;

    @PostMapping("addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        bookDbService.saveBook(bookMapper.mapToBook(bookDto));
    }

    @PutMapping("updateBookStatus")
    public BookDto updateBookStatus(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookDbService.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping("getAvaiableBooksNumber")
    public AvaiableBooksNumberDto getAvaiableBooksNumber(@RequestBody TitleDto titleDto) {
        return avaiableBookNumberMapper.mapToAvaiableBooksNumberDto(titleDbService.getAvaiableBooksNumberForTitle(titleMapper.mapToTitle(titleDto)));
    }

    @GetMapping("getBookByHashcode")
    public BookDto getBookByHashcode(@RequestParam Integer hashcode) throws BookNotFoundException {
        return bookMapper.mapToBookDto(bookDbService.findBookByHashcode(hashcode));
    }
}
