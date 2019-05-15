package com.kodilla.kodillalibrary.domain;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TITLES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Title {

    @Id
    @Column(name = "TITLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long titleId;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "AUTHOR")
    @NotNull
    private String author;

    @Column(name = "RELEASE_YEAR")
    private Date releaseDate;

    @OneToMany(
            targetEntity = Book.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "title")
    private List<Book> books;
}
