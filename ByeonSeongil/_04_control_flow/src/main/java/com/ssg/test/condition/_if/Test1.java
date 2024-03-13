package com.ssg.test.condition._if;


import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        StringBuilder bd = new StringBuilder();

        System.out.print("정수1 입력 :");
        int num1 = sc.nextInt();
        System.out.print("정수2 입력 :");
        int num2 = sc.nextInt();
        System.out.print("연산자 입력(+ - * / %) :");
        char operator = sc.next().charAt(0);
        System.out.println("--------------------------");

        if (num1 < 0 || num2 < 0) {
            System.out.println("잘못 입력하셨습니다.");
        }

        bd.append(num1).append(" ").append(operator).append(" ")
                .append(num2).append(" ").append("= ");

        switch (operator) {
            case '+':
                bd.append(num1 + num2);
                break;
            case '-':
                bd.append(num1 - num2);
                break;
            case '*':
                bd.append(num1 * num2);
                break;
            case '/':
                bd.append(num1 / num2);
                break;
            case '%':
                bd.append(num1 % num2);
                break;

            default:
                System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println(bd.toString());
    }
}
