package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.StatusOfBook;
import com.kodilla.kodillalibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookDbService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Integer getAvaiableBooks(final Book book) {
        return bookRepository.findAllByStatusEqualsAndTitle(StatusOfBook.AVAIABLE, book.getTitle()).size();
    }

    public Optional<Book> findBookById(final Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(final Long id) {
        bookRepository.deleteById(id);
    }

}
