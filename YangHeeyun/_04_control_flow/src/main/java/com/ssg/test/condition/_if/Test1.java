package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("정수1 입력 : ");
        int n1 = sc.nextInt();
        System.out.print("정수2 입력 : ");
        int n2 = sc.nextInt();
        System.out.print("연산자 입력 (+ - * / %) : ");
        char operator = sc.next().charAt(0);

        int result = 0;

        if (n1<0 && n2<0){
            System.out.println("잘못 입력 하셨습니다.  프로그램을 종료합니다.");
        }else {
            switch (operator) {
                case '+':
                    result = n1 + n2;
                    System.out.println("---------------------------");
                    System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
                    break;
                case '-':
                    result = n1 - n2;
                    System.out.println("---------------------------");
                    System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
                    break;
                case '*':
                    result = n1 * n2;
                    System.out.println("---------------------------");
                    System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
                    break;
                case '/':
                    result = n1 / n2;
                    System.out.println("---------------------------");
                    System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
                    break;
                case '%':
                    result = n1 % n2;
                    System.out.println("---------------------------");
                    System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
                    break;
                default:
                    System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            }
        }

    }
}
