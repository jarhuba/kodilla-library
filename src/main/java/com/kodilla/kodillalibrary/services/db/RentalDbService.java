package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.controller.exception.RentalNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalDbService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental findRentalByRentedBookId(final Book book) throws RentalNotFoundException {
        return rentalRepository.findRentalByRentedBookId(book).orElseThrow(RentalNotFoundException::new);
    }

    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }
}
