package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.domain.dto.RentalDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalMapper {

    public Rental mapToBookRental(final RentalDto rentalDto) {
        return new Rental(rentalDto.getRentalId(), rentalDto.getRentalDate(), rentalDto.getReturnDate(), rentalDto.getBorrowedBookId(), rentalDto.getBorrowerUser());
    }

    public RentalDto mapToBookRentalDto(final Rental rental) {
        return new RentalDto(rental.getRentalId(), rental.getRentalDate(), rental.getReturnDate(), rental.getRentedBookId(), rental.getBorrowerUser());
    }

    public List<RentalDto> mapToBookRentalListDto(final List<Rental> rentalList) {
        return rentalList.stream()
                .map(bookRental -> new RentalDto(bookRental.getRentalId(), bookRental.getRentalDate(), bookRental.getReturnDate(), bookRental.getRentedBookId(), bookRental.getBorrowerUser()))
                .collect(Collectors.toList());
    }
}
