package com.sh._02.exception;

import com.sun.jdi.request.ExceptionRequest;

/**
 * <pre>
 * 호출한 메소드에서 예외가 발생할 수 있다.
 * 1. 예외처리 위임 - 발생할 예외를 try..catch하지 않고 호출부로 예외처리 책임을 넘긴다
 *    - ex)main->다른 메소드 ->리턴 돌아와서 main에서 try..catch를 한다
 * 2. 예외처리 - try..catch절을 통해 정상흐름/예외흐름을 분기한다.
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        ExceptionTest exceptionTest=new ExceptionTest();



        try {
            exceptionTest.checkEnoughMoney2(30000,50000);
            System.out.println("구매 가능합니다");
        }catch (Exception e) {
            System.out.println("구매할 수 없습니다");
        }



    }
}
