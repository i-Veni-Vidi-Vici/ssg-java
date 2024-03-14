package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    
    public void test() {
        Scanner sc = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char operator = ' ';

        // 정수 2개, 연산자 1개 입력
        System.out.print("정수1 입력 : ");
        num1 = sc.nextInt();
        System.out.print("정수2 입력 : ");
        num2 = sc.nextInt();
        System.out.print("연산자 입력 (+ - * / %) : ");
        operator = sc.next().charAt(0);

        // 입력 받은 정수가 음수이면 프로그램 종료
        if (num1 < 0 || num2 < 0) {
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            return;
        }

        // 입력 받은 연산자가 + - * / % 가 아니면, 프로그램 종료
        if(operator == '+') {
            result = num1 + num2;
        } else if(operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            result = num1 / num2;
        } else if (operator == '%') {
            result = num1 % num2;
        } else {
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            return;
        }

        System.out.println("------------------------------");
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }
}
