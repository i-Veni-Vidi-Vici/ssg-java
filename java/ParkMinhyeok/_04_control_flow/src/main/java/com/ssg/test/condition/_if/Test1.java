package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 1 입력: ");
        int a = sc.nextInt();
        System.out.print("정수 2 입력: ");
        int b = sc.nextInt();

        // 조기 return
        if (a < 0 || b < 0 ) {
            System.out.println("음수를 입력하셨습니다. 프로그램을 종료합니다");
            return;
        }
        System.out.print("연산자 입력 (+ - * / %) : ");
        char operator = sc.next().charAt(0);

        // 조기 return
        if (operator != '+' && operator != '-' && operator != '*' && operator != '%' && operator != '/') {
            System.out.println("연산자를 잘 못 입력하셨습니다. 프로그램을 종료합니다.");
            return;
        }

        int result = 0;
        System.out.println("---------------------");
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            case '%':
                result = a % b;
                break;
            default:
                System.out.println("잘못 입력 하셨습니다.");
                return;
        }
        System.out.println(a + " " + operator + " " + b + " = " + result);
    }
}
