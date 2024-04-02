package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() {/* throws InputMismatchException*/
        throw new InputMismatchException("헤헷");
    }

    public void checked() throws Exception {
        try {
            throw new Exception("체킷아웃!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
