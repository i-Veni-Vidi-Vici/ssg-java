package com.sh._02.exception;

import java.util.Scanner;

/**
 * <pre>
 *     Exception 예외
 *     -Error 와 마찬가지로 프로그램을 비정상 종료시킬수 있다.
 *     - 적절한 예외 처리를 통해서 다시 정상흐름으로 복구할 수 있는 미약한 오류
 *     예외 흐름
 *     1. 예외 던지기 throw new NullPointerException()
 *     2. 예외 제어
 *          - 예외 회피(위임): 메소드 선언에 throw 구문 작성. public void test() throws SomException {}
 *          - 예외 처리: try..catch 절을 통해서 예외 발생시 처리구문을 작성 (정상흐름 복구)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 산술 연산 예외
        // java.lang.ArithmeticException: / by zero
//        System.out.println(10 / 0); // 제수가 0이면 ArithmeticException 이 발생한다.

        // NPE 예외
        // java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
        try {
            String str = null;
            System.out.println(str.length()); // null 에 대해 field/method 참조할 수 없다.
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Scanner 사용시 입력값 오류
        // java.util.InputMismatchException
        try {
            // 오류가 발생할 수 있는 코드 작성
            Scanner sc = new Scanner(System.in);
            System.out.print("정수 입력: ");
            int n = sc.nextInt();

        }
        catch (Exception e) {
            // 오류가 발생했을때 실행할 코드 - catch 절이 실행되면, 예외처리되고 정상흐름 복구된다.
            System.out.println("정수만 입력해주세요...");
        }


        System.out.println("프로그램 정상 종료...");
    }
}
