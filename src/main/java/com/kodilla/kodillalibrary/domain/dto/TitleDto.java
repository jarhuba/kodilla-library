package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TitleDto {

    private Long titleId;
    private String title;
    private String author;
    private Date releaseDate;
    private List<Book> books;

    public TitleDto(String title, String author, Date releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}
