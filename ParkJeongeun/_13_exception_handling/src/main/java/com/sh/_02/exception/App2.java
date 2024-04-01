package com.sh._02.exception;

/**
 * <pre>
 * 호출한 메소드에서 예외가 발생할 수 있음
 * 1. 예외처리 위임 : 발생한 예외를 try-catch하지 않고 호출부로 예외처리 책임을 위임함
 * 2. 예외처리 : try-catch절을 통해 정상흐름/예외흐름을 분기함
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        // 1. if문으로 흐름 분기
//        boolean bool = exceptionTest.checkEnoughMoney(30000, 50000);
//        boolean bool = exceptionTest.checkEnoughMoney(30000, 25000);
//        if (bool)
//            System.out.println("구매 가능");
//        else
//            System.out.println("구매 불가능");

        // 2. 예외처리로 흐름 분기
        try{
//            exceptionTest.checkEnoughMoney2(30000, 50000); // 구매 가능
            exceptionTest.checkEnoughMoney2(30000, 25000); // 구매 불가능
            System.out.println("구매 가능");
        }catch (Exception e){
            System.out.println("구매 불가능");
        }

        System.out.println("프로그램 정상 종료");
    }
}
