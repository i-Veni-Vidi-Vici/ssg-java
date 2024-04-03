package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {

    public void unchecked() {
//        throw new RuntimeException("unchecked");
        throw new InputMismatchException("inputMismatch");
    }

    /**
     * 호출부로 예외처리 위임
     */
    public void checked() throws Exception {
        try {
            throw new Exception("예외 발생");
        }
        catch (Exception e) {
            // 즉시 예외 처리
        }
    }
}
