package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.RentalBook;
import com.kodilla.kodillalibrary.domain.dto.RentalBookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalBookMapper {

    public RentalBook mapToBookRental(final RentalBookDto rentalBookDto) {
        return new RentalBook(rentalBookDto.getRentalId(), rentalBookDto.getRentalDate(), rentalBookDto.getReturnDate(), rentalBookDto.getBorrowedBookId(), rentalBookDto.getBorrowerUser());
    }

    public RentalBookDto mapToBookRentalDto(final RentalBook rentalBook) {
        return new RentalBookDto(rentalBook.getRentalId(), rentalBook.getRentalDate(), rentalBook.getReturnDate(), rentalBook.getBorrowedBookId(), rentalBook.getBorrowerUser());
    }

    public List<RentalBookDto> mapToBookRentalListDto(final List<RentalBook> rentalBookList) {
        return rentalBookList.stream()
                .map(bookRental -> new RentalBookDto(bookRental.getRentalId(), bookRental.getRentalDate(), bookRental.getReturnDate(), bookRental.getBorrowedBookId(), bookRental.getBorrowerUser()))
                .collect(Collectors.toList());
    }
}
