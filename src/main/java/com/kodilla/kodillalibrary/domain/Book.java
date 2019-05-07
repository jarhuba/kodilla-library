package com.kodilla.kodillalibrary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @Column(name = "BOOKID")
    private long bookId;

    @Column(name = "TITLEID")
    private long titleId;

    @V
    private enum status {avaiable, lost, destroyed}
}
