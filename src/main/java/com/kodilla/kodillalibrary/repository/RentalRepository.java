package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.RentalBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalBook, Long> {
}
