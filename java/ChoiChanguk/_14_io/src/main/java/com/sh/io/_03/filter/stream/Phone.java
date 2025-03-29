package com.sh.io._03.filter.stream;

import java.io.Serializable;

public class Phone implements Serializable {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
