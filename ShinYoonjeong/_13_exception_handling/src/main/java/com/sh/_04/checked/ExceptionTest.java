package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() {
        //throw new RuntimeException("헤헷");
        throw new InputMismatchException("타입 변환 불가!");
    }

    /**
     * 호출부로 예외처리 위임
     */
    public void checked() throws Exception {

        throw new Exception("체킷아웃!!");



    }
}
