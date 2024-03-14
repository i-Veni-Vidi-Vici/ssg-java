package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("정수2 입력 : ");
        int num2 = sc.nextInt();
        System.out.print("연산자 입력 (+ - * / %) : ");
        String operator = sc.next();
        System.out.println("--------------------------");

        if (num1 < 0 || num2 < 0) {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
            return;
        }

        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
                return;
        }
        System.out.println(num1 + " " + operator + " " + num2 + " " + "=" + " " + result);
    }
}
