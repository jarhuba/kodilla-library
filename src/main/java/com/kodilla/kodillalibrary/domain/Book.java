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
    @NotNull
    private StatusOfBook status;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "RELATED_TITLE_ID")
    @NotNull
    private Title title;

    @OneToOne
    @JoinColumn(name = "BOOK_RENTAL_ID")
    private Rent rentId;

    @Column(name = "HASHCODE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookUuid = UUID.randomUUID().toString();
}