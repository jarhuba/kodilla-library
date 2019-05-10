package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.BookRental;
import com.kodilla.kodillalibrary.domain.BookStatus;
import com.kodilla.kodillalibrary.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto {

    private Long bookId;
    private BookStatus status;
    private Title title;
    private BookRental bookRentalId;
}
