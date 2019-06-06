package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitleRepository extends JpaRepository<Title, Long> {

    Optional<Title> findByTitleId(Long titleId);

    @Override
    Title save(Title title);
}
