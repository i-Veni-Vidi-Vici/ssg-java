package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() /* throws InputMismatchException */ {
//        throw new RuntimeException("하하");
//        throw new NullPointerException("널널해요");
        throw new InputMismatchException("타입변환 불가");
    }

    /**
     * 호출부로 예외처리 위임
     */
    public void checked() throws Exception{
        throw new Exception("체킷아웃");
//        try {
//            throw new Exception("체킷아웃"); // 예외처리(try..catch)를 강제화해야한다.
//        } catch(Exception e) {
//            // 즉시 예외처리
//        }
    }
}
