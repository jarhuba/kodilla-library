package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.controller.exception.BookNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookDbService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(final Long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public Book findBookByBookUuid(final String bookUuid) throws BookNotFoundException {
        return bookRepository.findBookByBookUuid(bookUuid).orElseThrow(BookNotFoundException::new);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(final Long id) {
        bookRepository.deleteById(id);
    }
}
