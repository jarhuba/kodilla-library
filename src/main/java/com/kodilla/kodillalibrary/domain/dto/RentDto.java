package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RentDto {

    private Long rentalId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Book rentedBookId;
    private User borrowerUser;
}
