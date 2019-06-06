package com.kodilla.kodillalibrary;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootJPAIntegrationTest {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void givenTitleEntityRepository_whenSaveAndRetreiveEntity_thenOK() throws TitleNotFoundException{
        //Given
        Title title = new Title(1l, "Rzeczpospolita","Jacek Bartosiak",new Date(2018,5,5), new ArrayList<>());
        titleRepository.save(title);
        //When
        Title readedTitle = titleRepository.findByTitleId(title.getTitleId()).orElseThrow(TitleNotFoundException::new);
        //Then
        assertEquals(title, readedTitle);
    }
}
