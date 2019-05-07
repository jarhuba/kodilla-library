package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TITLES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Title {

    private long titleId;
    private String title;
    private String author;
    private Date releaseDate;
}
