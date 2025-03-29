package com.sh.condition._switch;

import java.util.Scanner;

/**
 * <pre>
 *     switch문
 *     - 논리값이 값으로써 분리처리하는 제어문
 *     - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 *     - byte, short, int, char, String(1.7부터), enum(상수) 사용가능
 *     - boolean, long, float, double 사용불가
 *
 * switch 표현식
 *
 * switch(값) {
 *     case 값1:
 *     // 값1일때 실행코드
 *     break;
 *     case 값2:
 *     // 값2일때 실행코드
 *     break;
 *     ...
 *     default:
 *     // 모든 case문의 값에 해당되지 않은 경우, 기본적으로 실행되는 코드
 * }
 * </pre>
 */

public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);

        // switch문 안에서 사용할 변수는 switch 블럭 밖에서 선언한다.
        // switch문의 case에 해당되지 않아 default만 실행되는 경우가 있을 수 있으므로, 변수  초기화까지 함
        String name = "";
        int price = 0;

        String menu = "======================\n"
                    + "자판기\n"
                    + "======================\n"
                    + "1. 사이다 - 1000\n"
                    + "2. 콜라 - 1500\n"
                    + "3. 환타 - 1300\n"
                    + "======================\n"
                    + "입력 : ";
        System.out.println(menu);
        String choice = sc.next();      // int형으로 입력 받으면 ` 등 다른 문자등을 입력하면 오류가 발생할 수 있으므로, 되도록 String으로 하는 것이 좋다.

        switch(choice) {
            case "1":
                name = "사이다";
                price = 1000;
                break;
            case "2":
                name = "콜라";
                price = 1500;
                break;
            case "3":
                name = "환타";
                price = 1300;
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }

        System.out.println(name + "를 선택하셨습니다. 가격은 " + price + "원입니다.");
    }

    /**
     * <pre>
     *     학점부여
     * - 90 ~ 100 -> A
     * - 80 ~ 89 -> B
     * - 70 ~ 79 -> C
     * - 60 ~ 69 -> D
     * - 0 ~ 59 -> F
     * </pre>
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 점수 입력 : ");
        int score = sc.nextInt();
        char grade = ' ';                   // 공백문자로 초기화

        /**
         * fall-through
         * - switch-case문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
         */

        switch(score/10) {
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

        System.out.println(score + "점은 " + grade + "학점입니다.");
    }

    /**
     * <pre>
     *     사용자에게 정수 2개, 연산자(+,-,*,/,%) 1개를 입력받아서
     *     정수 2개에 대해 해당 연산 결과를 출력하세요.
     *
     *     > 정수1 입력 : 30
     *     > 정수2 입력 : 20
     *     > 연산자 입력 (+ - * / %) : +
     *     > 결과 출력 : 30 + 20 -> 50
     * </pre>
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char operator = ' ' ;

        System.out.print("> 정수1 입력 : ");
        num1 = sc.nextInt();
        System.out.print("> 정수2 입력 : ");
        num2 = sc.nextInt();
        System.out.print("> 연산자 입력 (+ - * / %) : ");
        operator = sc.next().charAt(0);

        switch(operator) {
            case '+': result = num1 + num2; break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '%':
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
                return;                                     // 리턴문으로 연산자 잘못 입력한 경우 조기리턴으로 하위 코드 실행하지 않고 함수 종료
        }
        System.out.println(num1 + " " + operator + " " + num2 + " -> " + result);
    }
}
