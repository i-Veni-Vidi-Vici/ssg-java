package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 입력 : ");
        int int1 = sc.nextInt();
        if (int1 < 0) {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        System.out.print("정수2 입력 : ");
        int int2 = sc.nextInt();
        if (int2 < 0) {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        System.out.print("연산자 입력 (+ - * / %) : ");
        char operator = sc.next().charAt(0);
        int result = 0;
        if (operator == '+') {
            result = int1 + int2;
        } else if (operator == '-') {
            result = int1 - int2;
        } else if (operator == '*') {
            result = int1 * int2;
        } else if (operator == '/') {
            result = int1 / int2;
        } else if (operator == '%') {
            result = int1 % int2;
        } else {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        System.out.println("---------------------------");
        System.out.println(int1 + " " + operator + " " + int2 + " = " + result);
    }
}
