package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "BOOKS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusOfBook status = StatusOfBook.AVAIABLE;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "TITLE_ID")
    @NotNull
    private Title title;

    @OneToOne
    @JoinColumn(name = "RENTAL_ID")
    private Rent rentId;

    @Column(name = "BOOK_UUID", updatable = false, nullable = false)
    private String bookUuid = UUID.randomUUID().toString();

    public Book(@NotNull Title title) {
        this.title = title;
    }
}