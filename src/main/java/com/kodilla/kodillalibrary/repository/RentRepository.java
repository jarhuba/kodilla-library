package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent, Long> {

    Optional<Rent> findRentalByRentedBookId(Long bookId);

    Optional<Rent> findRentalByRentalId(Long rentedBookId);
}
