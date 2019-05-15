package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.controller.exception.RentalNotFoundException;
import com.kodilla.kodillalibrary.controller.exception.TitleNotFoundException;
import com.kodilla.kodillalibrary.controller.exception.UnsuccesfulRentException;
import com.kodilla.kodillalibrary.controller.exception.UserNotFoundException;
import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Rental;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.dto.RightToRentDto;
import com.kodilla.kodillalibrary.services.db.RentalDbService;
import com.kodilla.kodillalibrary.services.db.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentService {

    @Autowired
    private RentalDbService rentalDbService;
    @Autowired
    private RentRefusalLogicService rentRefusalLogicService;
    @Autowired
    private UserDbService userDbService;

    public Rental rentBook(Title title, User user) throws TitleNotFoundException, UserNotFoundException, UnsuccesfulRentException {
        RightToRentDto rightToRentDto = rentRefusalLogicService.checkRules(user, title);
        if (rightToRentDto.isAvaiable() && rightToRentDto.isRentedLessThanFour()) {
            Rental rental = new Rental();
            rental.setBorrowerUser(user);
            rental.setRentalDate(LocalDate.now());
            return rentalDbService.saveRental(rental);
        } else {
            String explain = "Książka nie wypożyczona, ponieważ: \n";
            if (!rightToRentDto.isAvaiable()) {
                explain += "- brak wybranej książki do wypożyczenia\n";
            }
            if (rightToRentDto.isRentedLessThanFour()) {
                explain += "- użytkownik ma wypożyczone dopuszczalne trzy książki\n";
            }
            throw new UnsuccesfulRentException(explain);
        }
    }

    public Rental returnBook(Book book) throws RentalNotFoundException {
       Rental rental = rentalDbService.findRentalByRentedBookId(book);
       rental.setReturnDate(LocalDate.now());
       rental.getBorrowerUser().getRentalsForUser().remove(rental); //TODO sprawdź czy zapisuje zmianę
       return rental;
    }
}
