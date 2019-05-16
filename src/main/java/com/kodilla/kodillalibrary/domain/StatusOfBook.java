package com.kodilla.kodillalibrary.domain;

import lombok.Getter;

public enum StatusOfBook {

    AVAIABLE("avaiable"), LOST("lost"), DESTROYED("destroyed"), BORROWED("borrowed");

    @Getter
    private String status;

    StatusOfBook(String status) {
        this.status = status;
    }
}
