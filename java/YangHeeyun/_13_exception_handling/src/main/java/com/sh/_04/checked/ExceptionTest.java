package com.sh._04.checked;

public class ExceptionTest {
    public void unchecked() /*throws InputMismatchException */{
        // uncheckd에서 throws를 보내도 되지만 굳이 넣지 않는게 일반적
        System.out.println("헤헷");
    }

    /**
     * 호출부로 예외처리를 위임
     */
    public void checked() throws Exception{
        throw new Exception("체킷아웃!!");
    }
}
