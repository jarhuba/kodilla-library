package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.RentalBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalRepository extends JpaRepository<RentalBook, Long> {

    Optional<RentalBook> findRentalBookByRentedBookId(Book book);
}
