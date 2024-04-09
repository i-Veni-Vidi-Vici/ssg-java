package com.sh._02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception 예외
 * - Error와 마찬가지로 프로그램을 비정상 종료시킬 수 있다.
 * - 적절한 예외처리를 통해서 다시 정상 흐름으로 복구할 수 있는 미약한 오류,
 *
 * 예외흐름
 * 1. 예외 던지기 throw new NullPointerException();
 * 2. 예외제어 // 던져진 예외를 제어하는 방법 2가지
 *  - 예외회피 : 메소드 선언에 throw 구문을 작성하는 것임. public void Test() throw SomeException {}
 *  - 예외처리 : try..catch절을 통해서 예외발생 시 처리구문을 작성(정상흐름 복구)
 */
public class App {
    public static void main(String[] args) {
        //산술연산 예외
        try {


        System.out.println(10/0); // 제수가 0이면 ArithmeticException이 발생함 //ArithmeticException: / by zero
        } catch (ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니당");
        }
        //NPE 예외

        try {
            String str = null;
        System.out.println(str.length()); // null에 대해 필드/메소드참조 불가능함 //control art t
        } catch (NullPointerException e ) {
            System.out.println("str는 null일 수 없습니당!!!!!!");
        }

        //입력값 오류 : Scanner 사용 시
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("정수 입력");
            int n = scanner.nextInt(); //여기서 오류 발생하면 바로 hump ㄸㅇ-ㅏㅇㅇ어--ㅓㅓ
            System.out.println("입력한 정수는" + n + "입니다");
            // 오류가 발생할 수 있는 코드를 작성함

        } catch (InputMismatchException e) {
            // 오류가 발생했을 때 실행할 코드 - catch절이 실행되면 , 예외가 처리되고 정상흐름으로 복구
            System.out.println("정수만 입력해 주세요"); //오류가 발생하지 않으면 건너 뛰고 출력

        }



        System.out.println("프로그램 정상 종료 ...");

    }
}
