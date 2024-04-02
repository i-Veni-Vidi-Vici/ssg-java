package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

/**
 * <pre>
 * 커스텀 예외 클래스로 분기 세분화하기
 *  - catch 절에는 다형성을 적용할 수 있다.
 *  - 자식 클래스 catch 절 - 부모 크래스 catch 절 순으로 작성한다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
//            exceptionTest.checkEnoughMoney(30_000, 20_000);
//            exceptionTest.checkEnoughMoney(-30_000, 20_000);
            exceptionTest.checkEnoughMoney(30_000, -20_000);
        } catch (NegativeException e) {
            System.out.println(e.getMessage() + 1);
            e.fillInStackTrace();
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage() + 3);
        }
        // Exception catch 절 하나면 모든 예외를 처리할 수 있다.
        // 자식 Exception 별로 분기처리 하고 싶은 경우 Exception catch 절 위에 작성하면 된다.
        catch (Exception e) {
            System.out.println("알 수 없는 오류 발생");
        }
        System.out.println("프로그램 정상 종료");
    }
}
