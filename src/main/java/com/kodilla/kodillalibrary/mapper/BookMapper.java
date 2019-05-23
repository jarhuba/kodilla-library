package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        if (bookDto.getBookUuid() == null) {
            return new Book(bookDto.getBookId(), bookDto.getStatusOfBook(), bookDto.getTitle(), bookDto.getRentId(), UUID.randomUUID().toString());
        }
        return new Book(bookDto.getBookId(), bookDto.getStatusOfBook(), bookDto.getTitle(), bookDto.getRentId(), bookDto.getBookUuid());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getBookId(), book.getStatus(), book.getTitle(), book.getRentId(), book.getBookUuid());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookDto(book.getBookId(), book.getStatus(), book.getTitle(), book.getRentId(), book.getBookUuid()))
                .collect(Collectors.toList());
    }
}
