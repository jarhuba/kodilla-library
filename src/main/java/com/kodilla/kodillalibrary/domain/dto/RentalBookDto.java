package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RentalBookDto {

    private Long rentalId;
    private Date rentalDate;
    private Date returnDate;
    private Book borrowedBookId;
    private User borrowerUser;
}
