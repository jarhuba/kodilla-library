package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.dto.AvaiableBooksNumberDto;
import org.springframework.stereotype.Component;

@Component
public class AvaiableBookNumberMapper {

    public AvaiableBooksNumberDto mapToAvaiableBooksNumberDto(Integer booksNumber) {
        return new AvaiableBooksNumberDto(booksNumber);
    }
}
