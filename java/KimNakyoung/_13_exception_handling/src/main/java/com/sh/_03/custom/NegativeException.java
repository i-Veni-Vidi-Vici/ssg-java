package com.sh._03.custom;

public class NegativeException extends RuntimeException {

    public NegativeException(String message) {
        super(message); // 이 안에서 다시 호출
    }
}
