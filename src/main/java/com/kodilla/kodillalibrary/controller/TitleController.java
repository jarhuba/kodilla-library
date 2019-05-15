package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.dto.TitleDto;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.services.db.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/title")
public class TitleController {

    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private TitleDbService titleDbService;

    @PostMapping("addTitle")
    public void saveTitle(@RequestBody TitleDto titleDto) {
        titleDbService.saveTitle(titleMapper.mapToTitle(titleDto));
    }
}
