package com.kodilla.kodillalibrary.controller.exception;

public class UnsuccesfulRentException extends Exception{

    String explanation;

    public UnsuccesfulRentException(String explanation) {
        this.explanation = explanation;
    }
}
