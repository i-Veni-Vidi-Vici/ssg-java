package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() {
//        throw new RuntimeException("헤헷");
//        throw new NullPointerException("널널해");
        throw new InputMismatchException("타입변환 불가!");

    }

    public void checked() throws Exception {
        throw new Exception("첵첵");
    }
}
