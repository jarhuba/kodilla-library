package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.controller.exception.UnsuccesfulRentException;
import com.kodilla.kodillalibrary.controller.exception.UserNotFoundException;
import com.kodilla.kodillalibrary.domain.RentalBook;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.dto.RightToRentDto;
import com.kodilla.kodillalibrary.services.db.RentalBookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class RentBookService {

    @Autowired
    private RentalBookDbService rentalBookDbService;
    @Autowired
    private RentRefusalLogicService rentRefusalLogicService;

    public RentalBook rentBook(Title title, User user) throws TitleNotFoundException, UserNotFoundException, UnsuccesfulRentException {
        RightToRentDto rightToRentDto = rentRefusalLogicService.checkRules(user, title);
        if (rightToRentDto.isAvaiable() && rightToRentDto.isRentedLessThanFour()) {
            RentalBook rentalBook = new RentalBook();
            rentalBook.setBorrowerUser(user);
            rentalBook.setRentalDate(LocalDate.now());
            return rentalBookDbService.saveBookRental(rentalBook);
        } else {
            String s = "Książka nie wypożyczona, ponieważ: \n";
            if (!rightToRentDto.isAvaiable()) {
                s += "brak wybranej książki do wypożyczenia\n";
            }
            if (rightToRentDto.isRentedLessThanFour()) {
                s += "użytkownik ma wypożyczone dopuszczalne trzy książki\n";
            }
            System.out.println(s);
            throw new UnsuccesfulRentException(s);
        }
    }
}
