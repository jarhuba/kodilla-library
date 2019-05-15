package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.StatusOfBook;
import com.kodilla.kodillalibrary.domain.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByStatusEqualsAndTitle(StatusOfBook statusOfBook, Title title);

    Optional<Book> findBookByHashcode(Integer hashcode);

    @Override
    Book save(Book book);
}
