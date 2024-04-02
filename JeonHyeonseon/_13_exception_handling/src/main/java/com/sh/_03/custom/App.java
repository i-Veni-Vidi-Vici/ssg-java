package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

/**
 * <pre>
 * 커스텀 예외클래스로 분기 세분화하기
 * - catch절에는 다형성을 적용할 수 있다.
 * - 다만, 자식클래스 catch절 -> 부모클래스 catch절 순으로 작성해야 한다.
 * - 최상위 예외 클래스인 Exception catch절을 사용한다면, 모든 예외를 처리할 수 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
//            exceptionTest.checkEnoughMoney(30_000, 50_000);
//            exceptionTest.checkEnoughMoney(30_000, 25_000);
//            exceptionTest.checkEnoughMoney(-30_000, 25_000);
            exceptionTest.checkEnoughMoney(30_000, -25_000);
            System.out.println("구매 가능합니다.");
        } catch(NotEnoughMoneyException e) {
            System.out.println("구매 불가능합니다 : " + e.getMessage());
//        } catch (PriceNegativeException e) {  // 특정 클래스마다 catch절이 필요하다.
//            System.out.println("구매금액 오류 : " + e.getMessage());
//        } catch (MoneyNegativeException e) {
//            System.out.println("현재금액 오류 : " + e.getMessage());
        } catch (NegativeException e) { // MoneyNegativeException, PriceNegativeException 처리될 수 있어야 한다.
            System.out.println("입력값 오류 : " + e.getMessage());
            e.printStackTrace(); // 예외가 발생한 순간의 callstack정보도 출력한다.
        } catch (Exception e) {
            // 다형성을 통한 예외처리 (부모예외클래스가 catch절의 뒤에 위치해야 한다.)
            System.out.println("알 수 없는 오류가 발생했습니다. : " + e.getMessage());
        }

        // Exception catch절 하나면 모든 예외를 처리할 수 있다.
        // 자식 Exception별로 분기처리하고 싶은 경우는 Exception catch절 위에 작성하면 된다.
        try {
            exceptionTest.checkEnoughMoney(30_000, -25_000);
        } catch(Exception e) {  // catch절에서는 다형성이 적용된다.
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료.");
    }
}
