package com.sgg.test.condition._if;

import java.util.Scanner;

public class Test1 {

    // 문제1
    public void test1() {
        Scanner sc = new Scanner(System.in);
        // 정수1 입력
        System.out.print("정수1 입력 :");
        int num1 = sc.nextInt();
        // 정수2 입력
        System.out.print("정수2 입력 :");
        int num2 = sc.nextInt();
        System.out.print("연산자 입력 (+ - * / %) : ");
        char operator = sc.next().charAt(0);

        int result = 0;

        if(num1 < 0 || num2 < 0)
        {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
        }
        else if(operator == '+') {
            result = num1 + num2;
        }
        else if(operator == '-') {
            result = num1 - num2;
        }
        else if(operator == '*') {
            result = num1 * num2;
        }
        else if(operator == '/') {
            result = num1 / num2;
        }
        else if(operator == '%') {
            result = num1 % num2;
        }else {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
        }
        System.out.println("---------------------------------");
        System.out.println(num1 + " " + operator + " " + num2 + "=" + result);
    }

}
