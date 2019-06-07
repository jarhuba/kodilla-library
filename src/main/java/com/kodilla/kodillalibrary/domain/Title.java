package com.kodilla.kodillalibrary.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TITLES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "RELEASE_DATE")
    @NotNull
    private LocalDate releaseDate;

    @OneToMany(
            targetEntity = Book.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "title")
    private List<Book> books;

    public Title(@NotNull String title, @NotNull String author, @NotNull LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return titleId.equals(title1.titleId) &&
                title.equals(title1.title) &&
                author.equals(title1.author) &&
                releaseDate.equals(title1.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleId, title, author, releaseDate);
    }
}
