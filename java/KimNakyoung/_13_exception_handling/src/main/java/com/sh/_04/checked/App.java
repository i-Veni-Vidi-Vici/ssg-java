package com.sh._04.checked;

import com.sh._02.exception.ExceptionTest;

/**
 * <pre>
 * Exception구분
 * 1. Checked Exception
 * - RuntimeException계열을 제외한 모든 예외클래스
 * - 예외처리(try..catch)를 강제화함. 예외처리 안하면 compile 오류 발생.
 *
 * 2. Unchecked Exception
 *  - RuntimeException 의 하위클래스
 *  - 예외처리(try..catch)를 강제화 하지 않음
 *  - 개발자 재량으로 예외처리 해야함. 최근 추세는 Unchecked!
 *
 * </pre>
 *
 *
 */



public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        //uncheked 예외 발생해도 프로그램은 비정상 종료된다.
        // 다만 try.catch작성을 강제화 하지 않을 뿐

        try {
            exceptionTest.unchecked();
        } catch (Exception e) {
            System.out.println("예외처리 성공!");
        }

        try {
            exceptionTest.checked(); // 호출부로 예외처리 책임 넘어감
        } catch (Exception e) {
            System.out.println("예외처리 성공!");
        }

        System.out.println("프로그램 정상 종료");
    }
}
