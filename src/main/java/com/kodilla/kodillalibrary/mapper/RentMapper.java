package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Rent;
import com.kodilla.kodillalibrary.domain.dto.RentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentMapper {

    public Rent mapToRental(final RentDto rentDto) {
        return new Rent(rentDto.getRentalId(), rentDto.getRentalDate(), rentDto.getReturnDate(), rentDto.getRentedBookId(), rentDto.getBorrowerUser());
    }

    public RentDto mapToRentalDto(final Rent rent) {
        return new RentDto(rent.getRentalId(), rent.getRentalDate(), rent.getReturnDate(), rent.getRentedBookId(), rent.getBorrowerUser());
    }

    public List<RentDto> mapToRentalListDto(final List<Rent> rentList) {
        return rentList.stream()
                .map(bookRental -> new RentDto(bookRental.getRentalId(), bookRental.getRentalDate(), bookRental.getReturnDate(), bookRental.getRentedBookId(), bookRental.getBorrowerUser()))
                .collect(Collectors.toList());
    }
}
