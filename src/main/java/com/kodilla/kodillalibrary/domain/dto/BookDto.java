package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Rent;
import com.kodilla.kodillalibrary.domain.StatusOfBook;
import com.kodilla.kodillalibrary.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto {

    private Long bookId;
    private StatusOfBook statusOfBook;
    private Title title;
    private Rent rentId;
    private String bookUuid;

}
