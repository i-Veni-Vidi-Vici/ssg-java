package com.sh._02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <pre>
 * Exception 예외
 *  - Error와 마찬가지로 프로그램을 비정상 종료시킬 수 있음
 *  - 적절한 예외처리를 통해 다시 정상흐름으로 복구할 수 있는 미약한 오류
 *
 *  예외흐름
 *  1. 예외 던지기 throw new NullPointerException();
 *  2. 예외제어
 *  - 예외회피(위임) : 메소드 선언에 throws 구문 작성 -> public void test() throws SomeException{}
 *  - 예외처리 : try..catch절을 통해 예외 발생 시 처리구문을 작성 -> 정상흐름 복구
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 산술연산 예외
//        System.out.println(10/3); // 3
        try{
            System.out.println(10/0); // 제수가 0이면 ArithmeticException 발생
        }catch (ArithmeticException a){
            System.out.println("0으로 나누지 마세요.");
        }

        // NPE 예외
        try{
            String str = null;
            System.out.println(str.length()); // null에 대해 field/method 참조할 수 없음
            // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
        }catch (NullPointerException n){
            System.out.println("str에 null을 제외한 값을 넣어주세요.");
        }

        // Scanner 사용시 입력값 오류
        Scanner sc = new Scanner(System.in);
        try{
            // 오류가 발생할 수 있는 코드 작성
            System.out.print("정수 입력 : ");
            int n = sc.nextInt(); // 문자열 입력 : Exception in thread "main" java.util.InputMismatchException
            System.out.println("입력한 정수는 " + n + "입니다.");
        } catch (InputMismatchException e){
            // 오류가 발생했을때 실행할 코드 작성 - catch절이 실행되면, 예외처리되고 정상흐름으로 복구된 것
            System.out.println("정수만 입력해주세요.");
        }

        System.out.println("프로그램 정상 종료");
    }
}
