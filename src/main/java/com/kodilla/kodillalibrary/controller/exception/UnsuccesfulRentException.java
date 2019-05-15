package com.kodilla.kodillalibrary.controller.exception;

public class UnsuccesfulRentException extends RuntimeException {

    public UnsuccesfulRentException(String explain) {
        super(explain);
    }
}
