package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.controller.exception.UserNotFoundException;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.dto.RightToRentDto;
import com.kodilla.kodillalibrary.services.db.TitleDbService;
import com.kodilla.kodillalibrary.services.db.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentRefusalLogicService {

    @Autowired
    private TitleDbService titleDbService;
    @Autowired
    private UserDbService userDbService;

    public RightToRentDto checkRules(User user, Title title) throws TitleNotFoundException, UserNotFoundException {
        boolean isAvaiable = titleDbService.findTitleById(title.getTitleId()).getBooks().size() > 0;
        boolean isRentedLessThanFour = userDbService.findUserById(user.getUserId()).getRentalsForUser().size() < 4;
        return new RightToRentDto(isAvaiable, isRentedLessThanFour);
    }
}
