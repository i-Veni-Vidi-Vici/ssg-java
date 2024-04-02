package com.sh._04.checked;

public class ExceptionTest {
    public void unchecked() /* throws InputMismatchException */ {
        throw new RuntimeException("헤헷");
    }

    // 호출부로 예외처리 위임
    public void checked() throws Exception{
        throw new Exception("체킷아웃");
    }
}
