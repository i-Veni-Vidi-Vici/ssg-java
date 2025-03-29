package com.sh._03.custom;


import com.sh._03.custom._exception.MoneyNegativeException;
import com.sh._03.custom._exception.NotEnoughMoneyException;
import com.sh._03.custom._exception.PriceNegativeException;

/**
 * 커스텀 예외클래스로 분기 세분화하기
 * -catch 절에는 다형성을 적용할 수 있다.
 * 자식클래스 catch절 - 부모클래스 catch절 순으로 작성해야한다.
 * 최상위 예외클래스인 Exception catch 절을 사용한다면, 모든 예외를 처리할 수 있다.
 */

public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
//            exceptionTest.checkEnoughMoney(30000, 50000);
            exceptionTest.checkEnoughMoney(30000, -25000);
            System.out.println("구매 가능합니다...");
        } catch (NotEnoughMoneyException e) {
            System.out.println("구매 불가능합니다 : " + e.getMessage());
        } catch (PriceNegativeException e){
            System.out.println("구매 금액 오류 : " + e.getMessage());
        } catch (MoneyNegativeException e){
            System.out.println("현재금액 오류 : " + e.getMessage());
        } catch (Exception e){
            System.out.println("알 수 없는 오류가 발생했습니다.");
        }

        System.out.println("프로그램 정상 종료 ....");
    }
}
