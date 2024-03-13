package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 입력 : ");
        int num1 = sc.nextInt();    // 정수1
        System.out.print("정수2 입력 : ");
        int num2 = sc.nextInt();    // 정수2
        System.out.print("연산자 입력 (+ - * / %) : ");
        char operator = sc.next().charAt(0);    // 연산자
        System.out.println("--------------------------");

        int result = 0; // 결과값

        if(operator == '+') {
            result = num1 + num2;
        } else if(operator == '-') {
            result = num1 - num2;
        } else if(operator == '*') {
            result = num1 * num2;
        } else if(operator == '/') {
            result = num1 / num2;
        } else if(operator == '%') {
            result = num1 % num2;
        } else {
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}
