package com.ssg.test.condition._if;

import java.util.Scanner;

/**
 * 조건문 if 실습문제
 * - 문제 1
 */
public class Test1 {

    /**
     *- 정수 두개를 입력 받고, 연산자(`+ - * / %`)를 입력받은 다음 계산한 뒤  결과를 출력하는 계산기 프로그램을 만들어보세요.
     * - 음수가 입력되거나 연산자 이외의 문자가 입력되면 “잘못 입력 하셨습니다.  프로그램을 종료합니다.” 라는 문구가 출력되게 하세요.
     *
     */

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 입력:");
        int num1 = sc.nextInt();
        System.out.print("정수2 입력:");
        int num2 = sc.nextInt();
        System.out.print("연산자 입력 ( + - * / % ):");
        char orperator = sc.next().charAt(0);
        int result = 0;
        switch (orperator) {
            case '+' : result = num1 + num2 ; break;
            case '-' : result = num1 - num2 ; break;
            case '*' : result = num1 * num2 ; break;
            case '/' : result = num1 / num2 ; break;
            case '%' : result = num1 % num2 ; break;
            default:
                System.out.println("잘못 입력 하셨습니다.");
                return;
        }
        System.out.println(num1 + " " + num2 + " " + "= " + result);
    }
}
