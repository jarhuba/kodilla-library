package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.domain.Title;
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

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
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
