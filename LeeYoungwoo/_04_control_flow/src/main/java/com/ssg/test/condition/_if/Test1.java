package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수1 입력 : ");
        int num1 = sc.nextInt();
        System.out.println("정수2 입력 : ");
        int num2 = sc.nextInt();
        System.out.println("연산자 입력 (+ - * / %) : ");
        String str = sc.next();
        int result = 0;

        switch (str) {
            case "+" : result = num1 + num2; break;
            case "-" : result = num1 - num2; break;
            case "*" : result = num1 * num2; break;
            case "/" : result = num1 / num2; break;
            case "%" : result = num1 % num2; break;
            default  :
                System.out.println("잘못 입력 하셨습니다.  프로그램을 종료합니다.");
                return;
        }
        System.out.println("------------------\n" +
                num1 + str + num2 + " = " + result);
    }
}
