package com.sh._03.custom;


import com.sh._03.custom.excetion.NotEnoughMoneyException;

/**
 * <pre>
 * 커스텀 예외클래스로 분기 세분화하기
 * - catch절에는 다형성을 적용할 수 있다.
 * - 자식클래스 catch절 - 부모클래스 catch절순으로 작성해야 한다.
 * - 최상위 예외클래스인  Exception catch절을 사용한다면, 모든 예외를 처리할 수 있다.
 *
 * </pre>
 */



public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
            // 예외 던질 법한 코드는 여기 작성
            exceptionTest.checkEnoughMoney(-30_000,25_000);
            System.out.println("구매 가능 합니다.");

        }
        catch (NotEnoughMoneyException e) {
            System.out.println("구매 불가능합니다.. : " + e.getMessage()); // 안에 있는 메세지 출력

        } catch (NegativeException e) {
            System.out.println("입력값 오류 : " + e.getMessage());
            e.printStackTrace(); // 예외가 발생한 순간의 callstack 정보 출력 (이거 찍혔다고 해서 비정상처리 x 그냥 볼려고 하는거임)

//        catch (PriceNegativeException e) {
//            System.out.println("구매금액 오류 :" + e.getMessage()); // 특정 클래스마다 캐치 절 이 필요하구나!
//        } catch (MoneyNegativeException e) {
//            System.out.println("지정금액 오류 : " + e.getMessage());
        } catch (Exception e)
        {
            // 다형성을 통한 예외처리 ( 부모 예외 클래스가 catch절의 뒤에 위치 해야한다!!) 순서 바뀌면 컴파일 오류
            System.out.println("알 수 없는 오류가 발생했습니다." + e.getMessage()); // 위에 오류 모두 아니다
        }

         // Exception catch절 하나면 모든 예외를 처리할 수 있다.
        // 자식 Exception별로 분기처리하고 싶은 경우는 Exception catch절 위에 작성하면 된다.

        try {
            exceptionTest.checkEnoughMoney(30_000,-25_000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("프로그램 정상 종료...");
    }
}
