package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 1 입력 : ");
        int num1 = sc.nextInt();

        System.out.print("> 정수 2 입력 : ");
        int num2 = sc.nextInt();

        System.out.print("> 연산자 입력 ( + - * / % ) : ");
        char operator = sc.next().charAt(0);

        int result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            result = num1 / num2;
        } else if (operator == '%') {
            result = num1 % num2;
        }
        System.out.println("===================");
        System.out.println(num1 + " "+ operator + " " + num2 + " = " + result + "🌞");
    }
}
