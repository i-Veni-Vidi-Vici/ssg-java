package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() {
//        throw new RuntimeException("hihi");
//        throw new NullPointerException("널널");
        throw new InputMismatchException("dmdkr");
    }

    /**
     * 호출부로 예외처리 위임
     */
    public void checked() throws  Exception{
        new Exception("예외처리");
        }
    }

