package com.sh._02.exception;


/**
 * <pre>
 *  호출한 메소드에서 예외가 발생할 수 있다.
 *  1. 예외처리 위임 - 발생한 예외를 try.. catch하지 않고 호출부로 예외처리 책임을 위임한다.
 *  2. 예외처리 - try..catch절을 통해 정상흐름/예외흐름을 분기한다.
 * </pre>
 *
 *
 */
public class App2 {
    public static void main(String[] args) {

        ExceptionTest exceptionTest = new ExceptionTest();

        //1. if문으로 흐름 분기

//        boolean bool = exceptionTest.checkEnoughMoney(30_000,25_000);
//        if(bool) {
//            System.out.println("구매가능");
//        }else{
//            System.out.println("구매할 수없습니다.");
//        }

        // 2. 예외처리로 흐름 분기
        try {
//            exceptionTest.checkEnoughMoney2(30_000,50_000); // 구매가능
            exceptionTest.checkEnoughMoney2(30_000,25_000); // 구매 불가능 (예외 던짐)
            System.out.println("구매 가능합니다..");
        } catch (Exception e) {
            // 만약 내 돈이 부족할 때 (예외 던저질 때)
            System.out.println("구매할 수 없습니다.");
        }

        System.out.println("프로그램 정상종료");

    }
}
