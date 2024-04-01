package _03.custom;

import _03.custom.exception.MoneyNegativeException;
import _03.custom.exception.NegativeException;
import _03.custom.exception.NotEnoughMoneyException;
import _03.custom.exception.PriceNegativeException;

/**
 * <pre>
 * 커스텀 예외클래스로 분기 세분화하기
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
//            exceptionTest.checkEnoughMoney(30_000, 50_000);
//            exceptionTest.checkEnoughMoney(30_000, 25_000);
            exceptionTest.checkEnoughMoney(-30_000, 25_000);
            exceptionTest.checkEnoughMoney(30_000, -25_000);
            System.out.println("구매 가능합니다...");
        } catch (NotEnoughMoneyException e) {
            System.out.println("구매 불가능합니다 : " + e.getMessage());
        }  catch (NegativeException e) {
            System.out.println("입력값 오류: " + e.getMessage());
            e.printStackTrace(); // 예외가 발생한 순간의 callstack 정보 출력
        }catch (Exception e) {
            // 다형성을 통한 예외처리 (부모예외클래스가 catch절의 뒤에 위치해야 한다.)
            System.out.println("알수 없는 오류가 발생했습니다. : " + e.getMessage());
        }

        // Exception catch절 하나면 모든 예외를 처리할 수 있다.
        // 자식 Exception별로 분기처리하고 싶은 경우는 Exception catch절 위에 작성하면됨
        try {
            exceptionTest.checkEnoughMoney(30_000, -25_000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료...");
    }
}
