package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BOOKS_RENTALS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @Column(name = "RENTAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentalId;

    @Column(name = "RENTAL_DATE")
    private LocalDate rentalDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "RENTED_BOOK_ID")
    private Book rentedBookId;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID_WHO_BORROWS")
    private User borrowerUser;

    public Rent(LocalDate rentalDate, LocalDate returnDate, Book rentedBookId, User borrowerUser) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentedBookId = rentedBookId;
        this.borrowerUser = borrowerUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent that = (Rent) o;
        return rentalId.equals(that.rentalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId);
    }
}
