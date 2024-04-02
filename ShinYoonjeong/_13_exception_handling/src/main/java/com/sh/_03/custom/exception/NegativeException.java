package com.sh._03.custom.exception;

public class NegativeException extends RuntimeException {
    public NegativeException(String message){
        super(message); // 부모로부터 물려받은 message:String필드에 값대입

    }
}
