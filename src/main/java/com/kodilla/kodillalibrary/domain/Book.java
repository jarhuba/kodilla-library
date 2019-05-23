package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    //@GeneratedValue(generator = "AVAIABLE")
    private StatusOfBook status;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String bookUuid;

    public Book(@NotNull Title title) {
        this.title = title;
    }
}