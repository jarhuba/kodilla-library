package com.kodilla.kodillalibrary.domain.dto;

import com.kodilla.kodillalibrary.domain.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    private List<Rent> rentalsForUser;
}
