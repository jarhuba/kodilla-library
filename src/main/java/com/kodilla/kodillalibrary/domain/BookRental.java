package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOKS_RENTALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookRental {

    @Id
    @Column(name = "RENTAL_ID")
    private Long rentalId;

    @Column(name = "RENTAL_DATE")
    private Date rentalDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "BORROWED_BOOK_ID")
    private Book borrowedBookId;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID_WHO_BORROWS")
    private User borrowerUser;
}
