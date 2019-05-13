package com.kodilla.kodillalibrary.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RightToRentDto {

    private boolean isAvaiable, isRentedLessThanFour;
}
