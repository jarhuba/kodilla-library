package com.kodilla.kodillalibrary.services.db;

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

    public Integer getAvaiableBooksNumberForTitle(final Title title) {
        return bookRepository.findAllByStatusEqualsAndTitle(StatusOfBook.AVAIABLE, title).size();
    }

    public Optional<Title> findTitleById(final Long id) {
        return titleRepository.findById(id);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitleById(final Long id) {
        titleRepository.deleteById(id);
    }
}
