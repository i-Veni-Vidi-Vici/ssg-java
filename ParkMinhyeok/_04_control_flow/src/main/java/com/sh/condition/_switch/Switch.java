package com.sh.condition._switch;

import java.util.Scanner;

public class Switch {
    Scanner sc = new Scanner(System.in);
    /**
     * fall-through
     * - switch-case 문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
     */
    public void test2() {
        System.out.println("> 점수 입력 : ");
        int score = sc.nextInt();
        char grade = ' ';

        switch (score / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                System.out.println("잘못된 입력값입니다.");

        }
    }

    public void test3() {
        int a = 0;
        int b = 0;
        char operator = ' ';
        int result = 0;

        a = sc.nextInt();
        operator = sc.next().charAt(0);
        b = sc.nextInt();

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
                System.out.println("잘못된 입력값입니다.");
                return;
        }
        System.out.println("결과 출력 : " + a + operator + b + " -> " + result);
    }
}
