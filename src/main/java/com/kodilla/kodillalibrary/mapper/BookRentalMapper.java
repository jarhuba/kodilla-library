package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.BookRental;
import com.kodilla.kodillalibrary.domain.dto.BookRentalDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRentalMapper {

    public BookRental mapToBookRental(final BookRentalDto bookRentalDto) {
        return new BookRental(bookRentalDto.getRentalId(), bookRentalDto.getRentalDate(), bookRentalDto.getReturnDate(), bookRentalDto.getBorrowedBookId(), bookRentalDto.getBorrowerUser());
    }

    public BookRentalDto mapToBookRentalDto(final BookRental bookRental) {
        return new BookRentalDto(bookRental.getRentalId(), bookRental.getRentalDate(), bookRental.getReturnDate(), bookRental.getBorrowedBookId(), bookRental.getBorrowerUser());
    }

    public List<BookRentalDto> mapToBookRentalListDto(final List<BookRental> bookRentalList) {
        return bookRentalList.stream()
                .map(bookRental -> new BookRentalDto(bookRental.getRentalId(), bookRental.getRentalDate(), bookRental.getReturnDate(), bookRental.getBorrowedBookId(), bookRental.getBorrowerUser()))
                .collect(Collectors.toList());
    }
}
