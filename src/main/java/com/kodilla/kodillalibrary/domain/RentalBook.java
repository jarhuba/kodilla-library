package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "BOOKS_RENTALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentalBook {

    @Id
    @Column(name = "RENTAL_ID")
    private Long rentalId;

    @Column(name = "RENTAL_DATE")
    private LocalDate rentalDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "BORROWED_BOOK_ID")
    private Book borrowedBookId;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID_WHO_BORROWS")
    private User borrowerUser;
}
