package com.sh._02.exception;

/**
 * 호출한 메소드에서 예외가 발생할 수 있다.
 * 1. 예외 처리 위임
 * 2. 예외 처리 - try...catch절을 통해 정상 흐름/예외흐름을 분기한다.
 */
public class App2 {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        /*boolean bool = exceptionTest.checkEnoughMony(30_000, 50_000);
        if(bool){
            System.out.println("구매 가능합니다...");
    }
        else
            System.out.println("구매할 수 없습니다.");*/
        // 2. 예외 처리로 흐름 분기
        try{
            exceptionTest.checkEnoughtMoney2(30_000, 25_000);
            System.out.println("구매 가능합니다.");
        }catch (Exception e){
            System.out.println("구매할 수 없습니다.");
        }

        System.out.println("프로그램 정상 종료");
    }
}
