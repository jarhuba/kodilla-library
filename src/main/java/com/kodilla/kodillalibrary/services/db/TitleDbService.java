package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.StatusOfBook;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TitleDbService {

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Integer getAvaiableBooksNumberForTitleId(final Long titleId) throws TitleNotFoundException{
        List<Book> books =(titleRepository.findAllByTitleId(titleId).orElseThrow(TitleNotFoundException::new)).getBooks();
        for(Book b : books) {
            if (!b.getStatus().equals(StatusOfBook.AVAIABLE)) {
                books.remove(b);
            }
        }
        return books.size();
    }

    public Title findTitleById(final Long titleId) throws TitleNotFoundException {
        return titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitleById(final Long id) {
        titleRepository.deleteById(id);
    }
}
