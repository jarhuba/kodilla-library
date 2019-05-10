package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.domain.BookRental;
import com.kodilla.kodillalibrary.repository.BookRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookRentalDbService {

    @Autowired
    private BookRentalRepository bookRentalRepository;

    public List<BookRental> getAllRentals() {
        return bookRentalRepository.findAll();
    }

    public Optional<BookRental> findBookRentalById(final Long id) {
        return bookRentalRepository.findById(id);
    }

    public BookRental saveBookRental(final BookRental bookRental) {
        return bookRentalRepository.save(bookRental);
    }

    public void deleteBookRentalById(final Long id) {
        bookRentalRepository.deleteById(id);
    }

}
