package com.sh.condition._switch;

import java.util.Scanner;

/**
 * switch문
 * - 논리값이 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식
 * - byte, short, int, String(1.7부터), enum 사용가능
 * - boolean, long, float, double
 * <p>
 * switch 표현식
 * switch(값) {
 * case 값1:
 * // 값1일때 실행코두
 * breek;
 * case 값2:
 * // 값2일때 실행코드
 * break;
 * ...
 * default
 * // 모든 case문이 실행되지 않은 경우 기본실행문
 * }
 */
public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);
        String menu = "=================\n"
                + " 자판기\n"
                + "=================\n"
                + "사이다 - 1500\n"
                + "=================\n"
                + "입력: ";
        System.out.println(menu);
        String choice = sc.next();
        int price = 0;
        String name = ""; // 빈 문자열 초기화

        switch (choice) {
            case "1":
                System.out.println("사이다 가격 1500");
                break;
            case "2":
                System.out.println("콜라 가격 1500");
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println(name + "를 선택하셨습니다. 가격은" + price + "원입니다.");
    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수 입력: ");
        int score = sc.nextInt();
        char grade = ' '; // 빈문자열로 초기화

        /**
         * fall - through
         * - switch
         */
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
                grade = 'F';
        }
    }

    /**
     * 사용자에게 정수2개, 연산자(+ - * / %) 1개를 입력받아서
     * 정수 2개에 대해 해당 연산 결과를 출력하세요.
     * <p>
     * > 정수1 입력: 30
     * > 정수2 입력: 20
     * > 연산자입력 (+ - * / %) : +
     * > 결과 출력 : 30 + 20 -> 50
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        int result = Integer.MAX_VALUE;

        System.out.print("정수1 입력:");
        int num1 = sc.nextInt();
        System.out.print("정수2 입력:");
        int num2 = sc.nextInt();
        System.out.print("연산자 입력:");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다!");
                return; // 조기 리턴, 하위의 코드를 실행하지않고 리턴.
        }

        System.out.println("결과:" + result);

    }
}
