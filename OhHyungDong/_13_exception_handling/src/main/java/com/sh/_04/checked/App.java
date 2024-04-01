package com.sh._04.checked;

/**
 * <pre>
 *  Exception 구분
 *  1. Checked Exception :
 *   - RuntimeException계열을 제외한 모든 예외클래스
 *   - 예외처리(try..catch)를 강제화함. 예외처리 안하면 compile 오류 발생
 *  2. Unchecked Exception :
 *  - RuntimeException의 하위 클래스
 *  - 예외처리(try..catch)를 강제화 하지 않음.
 *  - 개발자 재량으로 예외처리 해야함. 최근 추세는 Unchecked
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        //Unchecked 예외가 발생해도 프로그램은 비정상 종료된다.
        //다만 try..catch작성을 강제화 하지 않을 뿐
//        try {
//            exceptionTest.unchecked();
//        } catch(Exception e){
//            System.out.println("예외처리 성공 ");
//        }

        //checked 예외
        try {
            exceptionTest.checked();
        } catch (Exception e) {
            System.out.println("예외처리 성공 !");
        }

        System.out.println("프로그램 정상종료. ");
    }
}
