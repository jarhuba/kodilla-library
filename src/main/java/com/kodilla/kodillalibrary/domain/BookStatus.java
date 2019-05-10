package com.kodilla.kodillalibrary.domain;

import lombok.Getter;

public enum BookStatus {

    AVAIABLE("avaiable"), LOST("lost"), DESTROYED("destroyed");

    @Getter
    private String status;

    BookStatus(String status) {
        this.status = status;
    }
}
