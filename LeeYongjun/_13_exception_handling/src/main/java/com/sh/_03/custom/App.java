package com.sh._03.custom;


import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

/**
 * <pre>
 * 커스텀 예외클래스로 분기 세분화하기
 * - Catch절에는 다형성을 적용할 수 있다.
 * - 자식클래스 catch절 - 부모클래스 catch절순으로 작성해야 한다.
 * - 최상위 예외클래스인 Exception...
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
//            exceptionTest.checkEnoughMoney(30000,50000);
//            exceptionTest.checkEnoughMoney(30000,-25000);
            exceptionTest.checkEnoughMoney(-30000,25000);
            System.out.println("구매 가능합니다...");
        }
        catch (NotEnoughMoneyException e){
            System.out.println("구매 불가능합니다 : " + e.getMessage());
        }
        catch (NegativeException e){ //MoneyNegativeException,PriceNegativeException 처리될 수 있어야한다.
            System.out.println("구매금액 오류 : " + e.getMessage());
            e.printStackTrace(); // 예외가 발생한 순간의 callstack 정보 출력
        }

        catch (Exception e){
            // 다형성을 통한 예외처리(부모예외클래스가 catch절의 뒤에 위치해야 한다.)
            System.out.println("알 수 없는 오류가 발생했습니다. : " + e.getMessage());
        }

        // Exception catch절 하나면 모든 예외를 처리할 수 있다.
        // 자식 Exception별로 분기처리하고 싶은 경우는 Exception catch절의 뒤에 위치해야 한다.
        try {
            exceptionTest.checkEnoughMoney(30000,-25000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료...");
    }
}
