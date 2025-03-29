package com.sh._02.exception;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <pre>
 *     - 예외 흐름
 *     1. 예외 던지기 throw new NullPointerException( );
 *     2. 예외를 제어하는 방법
 *         - 예외 회피(위임) : 메소드 선언에 throws 구문을 작성하는 것, public void test( ) throws SomeException{ }
 *         - 예외 처리 :  try…catch절을 통해서 예외 발생시, 처리 구문을 작성(정상 흐름 복구)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //산술 연산 예외
        //java.lang.ArithmeticException : / by zero
        try {
            System.out.println(10 / 0); // 제수가 0이면 ArithmeticException이 발생한다.

        } catch (ArithmeticException e) {
                System.out.println("제수는 0일 수 없습니다: ");
        }

        //NPE 예외
        String str = null;
//        java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
        try {
            System.out.println(str.length()); //null에 대해 field/method 참조할 수 없음

        } catch (NullPointerException e) {
            System.out.println("str는 null일 수 없습니다.");
        }

        //Scanner 사용시 입력값 오류
        Scanner sc = new Scanner(System.in);
        try {
            //오류가 발생할 수 있는 코드를 작성
            System.out.println("정수 입력 : ");
            int n = sc.nextInt(); //java.util.InputMismatchException
            System.out.println("입력한 정수는 " + n + "입니다.");
        } catch (InputMismatchException e) {
            //오류가 발생했을 때, 실행할 코드 작성 - catch 절이 실행되면, 예외처리 되고, 정상 흐름으로 복구됨
            System.out.println("정수만 입력해주세요 : ");

        }


        System.out.println("프로그램 정상 종료..");
    }

}
