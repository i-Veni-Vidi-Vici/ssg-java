package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() /*throws InputMismatchException */ {
//        throw new RuntimeException("헤헷");
//        throw new NullPointerException("널널해요");
        throw new InputMismatchException("타입 변환 불가!");
    }

    /**
     * 호출부로 예외처리 위임
     */
    public void checked() throws Exception{//이 예외처리에 대한 책임은 호출부에 있음!
        throw new Exception("체킷아웃!");
    }
}
