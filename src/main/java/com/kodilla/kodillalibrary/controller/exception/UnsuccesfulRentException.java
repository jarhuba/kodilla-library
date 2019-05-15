package com.kodilla.kodillalibrary.controller.exception;

public class UnsuccesfulRentException extends Exception{

    String explain;

    public UnsuccesfulRentException(String explain) {
        this.explain = explain;
    }
}
