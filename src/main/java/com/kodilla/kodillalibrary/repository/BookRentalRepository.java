package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentalRepository extends JpaRepository<BookRental, Long> {
}
