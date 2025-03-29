package com.sh._04.custom.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() {
//        throw new RuntimeException("헤헷");
//        throw  new NullPointerException("널널행요");
        throw new InputMismatchException("타입변환 불가!");
    }

    /** 호출부로 예외처리 위임
     *
     */
    public void checked() throws Exception{
            throw new Exception("체키아웃");
            //즉시 예외처리

    }
}
