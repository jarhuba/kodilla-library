package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.controller.exception.RentalBookNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.RentalBook;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.dto.RentalBookDto;
import com.kodilla.kodillalibrary.domain.dto.RightToRentDto;
import com.kodilla.kodillalibrary.repository.RentalRepository;
import com.kodilla.kodillalibrary.services.RentRefusalLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalBookDbService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<RentalBook> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<RentalBook> findBookRentalById(final Long id) {
        return rentalRepository.findById(id);
    }

    public RentalBook findRentalBookByRentedBookId(final Book book) throws RentalBookNotFoundException{
        return rentalRepository.findRentalBookByRentedBookId(book).orElseThrow(RentalBookNotFoundException::new);
    }

    public RentalBook saveBookRental(final RentalBook rentalBook) {
        return rentalRepository.save(rentalBook);
    }

    public void deleteBookRentalById(final Long id) {
        rentalRepository.deleteById(id);
    }

}
