package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

/**
 * <pre>
 * 커스텀 예외클래스로 분기 세분화하기
 * - 내가 Exception 클래스 만들어서 사용 (ex. NotEnoughMoneyException)
 * - catch절에는 다형성 적용 가능
 * - 자식클래스 catch절 - 부모클래스 catch절 순으로 작성해야함
 * - 최상위 예외클래스인 Exception catch절을 사용한다면 모든 예외 처리 가능
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try{
//            exceptionTest.checkEnoughMoney(30000, 50000); // 구매 가능
//            exceptionTest.checkEnoughMoney(30000, 25000); // 구매 불가능 : 25000가 30000보다 적습니다.
//            exceptionTest.checkEnoughMoney(-30000, 25000); // 구매금액 오류 : 구매가격은 음수일 수 없음 : -30000
            exceptionTest.checkEnoughMoney(30000, -25000); // 현재 가진 금액 오류 : 현재 가진 금액은 음수일 수 없음 : -25000
            System.out.println("구매 가능");
        } catch (NotEnoughMoneyException e){
            System.out.println("구매 불가능 : " + e.getMessage());
        } catch (NegativeException e){ // MoneyNegativeException, PriceNegativeException 처리
            System.out.println("입력값 오류 : " + e.getMessage());
            e.printStackTrace(); // 예외가 발생한 순간의 callstack 정보 출력

        // 다형성을 통한 예외처리 (부모 예외클래스가 catch절의 뒤에 위치해야 함)
        } catch (Exception e){
            System.out.println("알 수 없는 오류 발생 : " + e.getMessage());
        }

        // Exception catch절 하나면 모든 예외 처리 가능
        // 자식 Exception별로 분기처리하고 싶은 경우는 Exception catch절 위에 작성하면 됨
        try{
            exceptionTest.checkEnoughMoney(30000, -25000); // 현재 가진 금액 오류 : 현재 가진 금액은 음수일 수 없음 : -25000
            System.out.println("구매 가능");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");
    }
}
