package com.sh.condition._switch;

import java.util.Scanner;

/**
 * switch 표현식
 * - 논리값이 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 * - byte, short, int, char, String, enum(상수) 사용가능
 * - boolean, long, float, double 사용불가
 *
 * switch (값) {
 *     case 값1:
 *         break;
 *     default:
 * }
 */
public class Switch {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        String menu = "====================\n"
                    + "자판기\n"
                    + "====================\n"
                    + "1. 사이다: 1000원\n"
                    + "2. 콜라: 1500원\n"
                    + "3. 환타 1300원\n"
                    + "입력: ";
        System.out.println(menu);
        String choice = sc.next();

        // switch 안에서 사용할 변수는 switch 블럭 밖에서 선언한다.
        String name = ""; // 빈 문자열 초기화
        int price = 0; // 0 초기화

        switch (choice) {
            case "1":
                name = "사이다";
                price = 1_000;
                break;
            case "2":
                name = "콜라";
                price = 1_500;
                break;
            case "3":
                name = "환타";
                price = 1_300;
                break;
            default:
                System.out.println("잘못 입력하였습니다.");
        }

        System.out.println(name + "를 선택하셨습니다. 가격은 " + price + "입니다.");
    }

    // 학점 부여
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 점수 입력: ");
        int score = sc.nextInt();
        char grade = ' ';

        // fall-through
        // - switch-case 문에서 break 를 생략하면, 하위 case 문으로 이어서 진행된다.
        switch (score / 10) {
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
                grade = 'A';
        }

        System.out.println(score + "점은 " + grade + "학점입니다.");
    }

    /**
     * 사용자에게 정수 2개, 연산자(+, -, *, /, %) 1개를 입력 받아서
     * 정수 2개에 대해 해당 연산 결과를 출력하세요.
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 A 입력: ");
        int a = sc.nextInt();
        System.out.print("> 정수 B 입력: ");
        int b = sc.nextInt();
        System.out.print("> 연산자 입력 (+, -, *, /, %) : ");
        char operator = sc.next().charAt(0);
        int result = 0;

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
                System.out.println("잘못된 입력 입니다.");
                return; // 조기 return. 하위의 코드를 실행하지 않고 return
        }

        System.out.println("> 출력 결과: " + a + " " + operator + " " + b + " -> " + result);
    }
}
