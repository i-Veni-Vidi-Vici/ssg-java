package com.sh._04.custom.checked;

public class NotValidNumber extends RuntimeException{
    public NotValidNumber(String message){
        super(message);
    }
}
