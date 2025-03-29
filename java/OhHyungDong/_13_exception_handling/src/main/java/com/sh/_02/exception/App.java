package com.sh._02.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception 예외
 * - Error와 마찬가지로 프로그램을 비정상 종료 시킬 수 있따.
 * - 적절한 예외처리를 통해서 다시 정상흐름으로 복구할 수 있는 미약한 오류.
 *
 * 예외 흐름
 * 1. 예외 던지기 throw new NullPointerException();
 * 2. 예외 제어 방법
 *  - 예외 회피(위임) : 메소드 선언에 throws구문 작성. public void test() throws IOException() {...}, 예외처리를 직접적으로 하는게 아니라 메소드로 위임해서
 *  - 예외 처리  : try..catch절을 통해서 예외 발생시 처리구문을 작성(정상흐름 복구)
 */
public class App {
    public static void main(String[] args) {
        //산술 연산 예외
        try{
            System.out.println(10 / 0);
        }catch(ArithmeticException e){
            System.out.println("두번쨰 정수는 0을 입력하면 안됩니다. 다시 입력하세요");
        }

        //NPE 예외
        try {
            String str = null;
            System.out.println(str.length()); // null에 대해 field /methoD 참조할 수없다.
        } catch (NullPointerException e) {
            System.out.println("str는 null일 수 없습니다.");
        }

        //Scanner사용시 입력값 오류
        Scanner sc = new Scanner(System.in);
        try{
            //오류가 발생할 수 있는 코드 작성
            System.out.println("정수 입력 : ");
            int n = sc.nextInt(); // int가 아닌 다른 타입을 입력했을 때 InputMismatchExceptioon 오류가 발생
            System.out.println("입력한 정수는 " + n + "입니다. ");

        }catch(InputMismatchException e) {
            //오류가 발생했을 때 실행하는 코드 - catch절이 실행되면, 예외처리 되고 정상흐름 복구된다,
            System.out.println("정수만 입력해주세요. ");
        }


        System.out.println("프로그램 정상 종료 ");
    }
}
