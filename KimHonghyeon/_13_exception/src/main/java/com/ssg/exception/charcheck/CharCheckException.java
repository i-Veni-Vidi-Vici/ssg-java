package com.ssg.exception.charcheck;

public class CharCheckException extends RuntimeException{
    CharCheckException(){
        super();
    }
    CharCheckException(String msg){
        super(msg);
    }
}
