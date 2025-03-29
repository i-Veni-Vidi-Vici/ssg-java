package com.sh._03.custom;

import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;

/**
 * <pre>
 * 커스텀 예외클래스로 분기 세분화하기
 * - catch 절에는 다형성을 적용할 수 있다.
 * - 자식클래스 catch절 - 부모클래스 catch절순으로 작성해야 한다.
 * - 최상위 예외클래스인 Exception catch절을 사용한다면, 모든 예외 처리 가능.
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
//            exceptionTest.checkEnoughMoney(30_000, 50_000);
//            exceptionTest.checkEnoughMoney(-30_000, 25_000);
            exceptionTest.checkEnoughMoney(30_000, -25_000);
            System.out.println("구매 가능");
        } catch (NotEnoughMoneyException e){
            System.out.println("구매 불가 -> " + e.getMessage());
        } catch (NegativeException e){ // MoneyNegativeException, PriceNegativeException 처리될 수 있어야 함)
            System.out.println("입력값 오류 -> " + e.getMessage());
            e.printStackTrace(); // 예외가 발생한 순간의 callStack 정보 출력 ==> 서로 콘솔에 찍겠다고 경쟁하다가 순서 꼬일 수 있음.
        } catch (Exception e){
            // 다형성을 통한 예외처리 (부모예외클래스가 catch절의 뒤에 위치해야 함.)
            System.out.println("알 수 없는 오류 발생 .... : " + e.getMessage());
        }

        // Exception catch절 하나면 모든 예외 처리 가능
        // 자식 Exception 별로 분기처리하고 싶은 경우 Exception catch 절 위에 작성하면 된다.

        try {
            exceptionTest.checkEnoughMoney(30_000, -25_000);
        } catch (Exception e){ // Exception이 최고 조상 객체이기 때문에~
            e.printStackTrace();
        } // -> try에서 발생한 오류를 catch 절에서 모두 잡을 수 있을까? yes. 다형성 적용으로 인해 가능!!!


        System.out.println("프로그램 정상 종료");
    }
}
