package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.domain.StatusOfBook;
import com.kodilla.kodillalibrary.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto {

    private Long bookId;
    private StatusOfBook statusOfBook;
    private Title title;
    private Rental rentalId;
    private UUID hashcode;
}
