package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
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
    private Long titleId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
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
