package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.controller.exception.*;
import com.kodilla.kodillalibrary.domain.*;
import com.kodilla.kodillalibrary.domain.dto.RightToRentDto;
import com.kodilla.kodillalibrary.services.db.BookDbService;
import com.kodilla.kodillalibrary.services.db.RentDbService;
import com.kodilla.kodillalibrary.services.db.TitleDbService;
import com.kodilla.kodillalibrary.services.db.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentService {

    @Autowired
    private RentDbService rentDbService;
    @Autowired
    private UserDbService userDbService;
    @Autowired
    private BookDbService bookDbService;
    @Autowired
    private TitleDbService titleDbService;

    private RightToRentDto checkIsRentPossible(Title title, User user) throws TitleNotFoundException, UserNotFoundException {
        List<Book> booksTitle = titleDbService.findTitleById(title.getTitleId()).getBooks();
        int avaiableBooksForRental = 0;
        for (int i = 0; i < booksTitle.size(); i++) {
            if (booksTitle.get(i).getStatus().equals(StatusOfBook.AVAIABLE)) {
                avaiableBooksForRental++;
            }
        }
        boolean isAvaiable = avaiableBooksForRental > 0;
        boolean isRentedLessThanFour = userDbService.findUserById(user.getUserId()).getRentalsForUser().size() < 4;
        return new RightToRentDto(isAvaiable, isRentedLessThanFour);
    }

    private void rentBook(Title title) {
        for (int i = 0; i < title.getBooks().size(); i++) {
            if (title.getBooks().get(i).getStatus().equals(StatusOfBook.AVAIABLE)) {
                title.getBooks().get(i).setStatus(StatusOfBook.BORROWED);
                break;
            }
        }
    }

    public Rent rentTitle(final Title title, final User user) throws
            TitleNotFoundException, UserNotFoundException, UnsuccesfulRentException {

        RightToRentDto rightToRentDto = checkIsRentPossible(title, user);
        if (rightToRentDto.isAvaiable() && rightToRentDto.isRentedLessThanFour()) {
            Rent rent = new Rent();
            rent.setBorrowerUser(user);
            rent.setRentalDate(LocalDate.now());
            rentBook(title);
            return rentDbService.saveRental(rent);
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

    public Rent returnBook(String bookUuid) throws RentalNotFoundException, BookNotFoundException {
        Long bookId = bookDbService.findBookByBookUuid(bookUuid).getBookId();
        Long rentalId = rentDbService.findRentalByRentedBookId(bookId).getRentalId();
        rentDbService.findRentalByRentalId(rentalId).setReturnDate(LocalDate.now());
        rentDbService.findRentalByRentalId(rentalId).getBorrowerUser().getRentalsForUser().remove(rentDbService.findRentalByRentedBookId(bookId));
        return rentDbService.findRentalByRentalId(rentalId);
    }
}