package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TitleDto {

    private Long titleId;
    private String title;
    private String author;
    private LocalDate releaseDate;
    private List<Book> books;
}
