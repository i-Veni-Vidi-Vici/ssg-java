package com.sh._02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <pre>
 * Exception 예외
 * - Error와 마찬가지로 프로그램을 비정상 종료시킬 수 있다.
 * - 적절한 예외처리를 통해서 다시 정상흐름으로 복구할 수 있는 미약한 오류.
 *
 * 예외흐름
 * 1. 예외던지기  throw new NullPointException();
 * 2. 예외제어
 *  - 예외회피(위임) : 메소드선언에 throws구문 작성. public void test() throws SomeException {}
 *  - 예외처리 : try.catch절을 통해서 예외발생시 처리구문을 작성 (정상흐름 복구)
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 산술연산 예외
        // java.lang.ArithmeticException: / by zero
        try {
            System.out.println(10 / 0); // 제수가 0이면 ArithmeticException이 발생한다.
        } catch (ArithmeticException e) {
            System.out.println("제수는 0일 수 없습니다.");
        }

        // NPE 예외
        String str = null;
        try {
            System.out.println(str.length()); // null에 대해 field/method 참조할 수 없다.
        } catch (NullPointerException e) {
            System.out.println("str는 null일 수 없습니다.");
        }
        // java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null

        // Scanner사용시 입력값오류
        Scanner sc = new Scanner(System.in);
        try {
            // 오류가 발생할 수 있는 코드 작성
            System.out.println("정수 입력 : ");
            int n = sc.nextInt(); // java.util.InputMismatchException
            System.out.println("입력한 정수는 " + n + "입니다.");
        } catch(InputMismatchException e) {
            // 오류가 발생했을 때 실행할 코드 - catch절이 실행되면, 예외처리되고 정상흐름 복구된다.
            System.out.println("정수만 입력해주세요...");
        }

        System.out.println("프로그램 정상 종료...");
    }
}
