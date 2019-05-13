package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @OneToMany(
            targetEntity = RentalBook.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "borrowerUserId")
    private List<RentalBook> rentalsForUser;
}
