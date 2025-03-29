package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() /*throws InputMismatchException*/ {
//        throw new RuntimeException("헤헷");
//        throw new NullPointerException("널널해요");
        throw new InputMismatchException("타입변환 불가!");
    }

    public void checked() {
        try {
            throw new Exception("체킷아웃!!");
        } catch (Exception e) {
            // 즉시 예외처리
        }
    }
    /**
     * 호출부로 예외처리 위임
     * @throws Exception
     */
    public void checked2() throws Exception {
        throw new Exception("체킷아웃!!");
    }
}
