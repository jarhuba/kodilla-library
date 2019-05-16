package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.controller.exception.RentalNotFoundException;
import com.kodilla.kodillalibrary.domain.Rent;
import com.kodilla.kodillalibrary.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentDbService {

    @Autowired
    private RentRepository rentRepository;

    public List<Rent> getAllRentals() {
        return rentRepository.findAll();
    }

    public Rent findRentalByRentedBookId(final Long bookId) throws RentalNotFoundException {
        return rentRepository.findRentalByRentedBookId(bookId).orElseThrow(RentalNotFoundException::new);
    }

    public Rent findRentalByRentalId(final Long rentalId) throws RentalNotFoundException {
        return rentRepository.findRentalByRentalId(rentalId).orElseThrow(RentalNotFoundException::new);
    }

    public Rent saveRental(final Rent rent) {
        return rentRepository.save(rent);
    }
}
