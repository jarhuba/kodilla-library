package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(titleDto.getTitleId(), titleDto.getTitle(), titleDto.getAuthor(), titleDto.getReleaseDate(), titleDto.getBooks());
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(title.getTitleId(), title.getTitle(), title.getAuthor(), title.getReleaseDate(), title.getBooks());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(title -> new TitleDto(title.getTitleId(), title.getTitle(), title.getAuthor(), title.getReleaseDate(), title.getBooks()))
                .collect(Collectors.toList());
    }


}
