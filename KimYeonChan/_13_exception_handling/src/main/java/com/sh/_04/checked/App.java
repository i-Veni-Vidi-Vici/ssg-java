package com.sh._04.checked;

/**
 * Exception 구분
 * 1. Checked Exception:
 *  - RuntimeException 계열을 제외한 모든 예외 클래스
 *  - 예외처리(try..catch)를 강제화함. 예외처리 안하면 compile 오류 발생
 * 2. UnChecked Exception
 *  - RuntimeException 의 하위 클래스
 *  - 예외처리 (try..catch)를 강제화하지 않음
 *  - 개발자 재량으로 예외 처리 해야함. 최근 추세는 Unchecked
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        // unchecked 예외가 발생해도 프로그램은 비정상 종료가 됨
        // 다만 try..catch 작성을 강제화 하지 않을 뿐이다.
        try {
            exceptionTest.unchecked();
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // checked 예외
        try {
            exceptionTest.checked();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("프로그램 정상 종료");
    }
}
