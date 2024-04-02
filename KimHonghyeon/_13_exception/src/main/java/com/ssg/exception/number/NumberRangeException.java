package com.ssg.exception.number;

public class NumberRangeException extends RuntimeException{
    NumberRangeException(){super();}
    NumberRangeException(String msg){
        super(msg);
    }
}
