package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private BookStatus status;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "RELATED_TITLE_ID")
    private Title title;

    @OneToOne
    @JoinColumn(name = "BOOK_RENTAL_ID")
    private BookRental bookRentalId;
}