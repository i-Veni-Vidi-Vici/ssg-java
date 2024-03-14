package com.sh.condition._if;

import java.util.Scanner;

public class Test1 {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수1 입력 :");
        int num1 = sc.nextInt();
        System.out.print("> 정수2 입력 :");
        int num2 = sc.nextInt();
        System.out.print("> 연산자 입력 :");
        char operator = sc.next().charAt(0);
        int result = 0;

        switch (operator){
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
            case '/' :
                result = num1 / num2;
                break;
            case '%' :
                result = num1 % num2;
                break;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다.");
                return;
        }
        System.out.println("----------------------------------------------");
        System.out.println("> 출력 결과: " + num1 + " " + operator + " " + num2 + " -> " + result);
    }
}
