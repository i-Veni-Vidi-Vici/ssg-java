package com.sh._02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception예외
 * - Error 와 마찬가지로 프로그램을 비정상 종료시킬 수 있다.
 * - 적절한 예외처리를 통해서 다시 정상흐름으로 복구할 수 있는 미약한 오류/
 *
 *
 * 예외흐름
 * 1. 예외던지기 throw new NullPointException();
 * 2. 예외제어
 *  - 예외회피(위임) : 메소드 선언에 throws구문 작성. public void test() throws SomeException{}
 *  - 예외처리 : try..catch절을 통해서 예외발생시 처리 구문을 작성 (정살 흐름으로 복구)
 */
public class App {
    public static void main(String[] args) {
        // 산술연산 예외
        try {
            System.out.println(10/0);// 제수가 0이면 ArithmeticException이 발생한다
        }
        catch (ArithmeticException e)
        {
            System.out.println("제수는 0일 수 없습니다");
        }

        //java.lang.ArithmeticException: / by zero

        //NPE 예외
        String str=null;
        // java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
        try {
            System.out.println(str.length());

        }catch (NullPointerException e)
        {
            System.out.println("문자열이 초기화 되지 않았습니다");
        }



        //Scanner사용시 입력값 오류
        Scanner sc = new Scanner(System.in);
        try {
            // 오류가 발생할 수 있는 코드 작성
            System.out.println("정수를 입력해주세요 : ");
            int n=sc.nextInt();
            System.out.println("입력한 정수는 n입니다");

        } catch (InputMismatchException e) {
            // 오류가 발생했을 떄 실행할 코드 - catch절이 실행되면, 예외가 처리되고 정상흐름으로 복구
            System.out.println(" 정수만 입력해주세요 ");
        }

        System.out.println("프로그램 적상 종료...");
    }
}
