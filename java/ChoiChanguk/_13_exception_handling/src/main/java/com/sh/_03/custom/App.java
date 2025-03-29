package com.sh._03.custom;

import com.sh._02.exception.ExceptionTest;
import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;


/**
 * <pre>
 * 커스텀 예외클래스 분기 세분화하기
 * - catch절에는 다형성을 적용할 수 있다.
 * - 자식클래스 catch절 - 부모클래스 catch절 순으로 작성해야 한다.
 * - 최상위 예외클래스인 Exception catch절을 사용한다면, 모든 예외를 처리 할 수 있음
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        ExceptionTest exceptionTest=new ExceptionTest();

        try {
            exceptionTest.checkEnoughMoney(30000, -20000);
            System.out.println("구매 가능합니다...");

            /**
             * 만약 여기에 부모타입 즉 Exception이 와버리면 슈퍼클래스이기 때문에
             * 아래 캐치들이 일을 못한다 그래서 부모Exception은 맨 마지막에 둔다
             */
        }catch (NotEnoughMoneyException e)
        {
            System.out.println("구매 불가능 합니다 : "+e.getMessage());
        }
//        catch (PriceNegativeException e)
//        {
//            System.out.println("구매금액 오류 : "+e.getMessage());
//        }
//        catch (MoneyNegativeException e)
//        {
//            System.out.println("현재금액 오류 : "+e.getMessage());
//        }
        catch (NegativeException e)
        {
            System.out.println("입력 값 오류 : "+e.getMessage());
            // MoneyNegativeException,PriceNegativeException 처리될 수 있어야
            e.printStackTrace();//이게 찍혔다고 비정상 종료는 아니다 단순하게 찍힌거다
        }
        catch (Exception e)
        {
            //다형성을 통한 예외처리(부모예외클래스가 catch절의 뒤에 위치해아한다.
            System.out.println("알 수 없느 오류가 발생했습니다.");
        }

        try {
            exceptionTest.checkEnoughMoney(30000, -20000);
        }
        catch (Exception e)
        {// MoneyNegativeException 이런거 PriceNegativeException 이런 예외와도
            // 조상은 Exception이니깐 오류는 다 잡힌다
            //모든 예외를 처리 할 수 있다
            //자식 Exception별로 분기처리하고 싶은 경우는 Exception catch절 위에 작성하면 된다

            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료....");
    }
}
