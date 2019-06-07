package com.kodilla.kodillalibrary;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.BookRepository;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootJPAIntegrationTestSuite {

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private BookRepository bookRepository;

    private Title title;
    private Book book;

    @Before
    public void setUp() {
        title = new Title("Rzeczpospolita", "Jacek Bartosiak", LocalDate.of(2018, 05, 22));
        titleRepository.save(title);
        book = new Book(title);
        //bookRepository.save(book);
    }

    @Test
    public void givenTitleEntityRepository_whenSaveAndRetreiveEntity_thenOK() throws TitleNotFoundException {
        //Given

        //When
        Title readedTitle = titleRepository.findByTitleId(title.getTitleId()).orElseThrow(TitleNotFoundException::new);
        //Then
        assertEquals(title, readedTitle);
    }
}
