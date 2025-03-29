package _04.checked;

import java.util.InputMismatchException;

public class ExceptionTest {
    public void unchecked() {
//        throw new RuntimeException("헤헷");
        throw new NullPointerException();
//        throw new InputMismatchException();
    }

    /**
     * 호출부로 예외처리 위임
     */

    public void checked() throws Exception{

        throw new Exception("체크아웃");

//        try {
//            throw new Exception("체크아웃");
//        } catch (Exception e) {
//            // 즉식 예외처리
//        }
    }
}
