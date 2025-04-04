package com.sh.condition._switch;

import java.util.Scanner;

/**
 *<pre>
 * switch문
 * - 논리값이 값으로 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 * - byte, short, int, char, String(1.7부터), enum(상수) 사용가능
 * - boolean, long, float, double 사용불가
 *
 * switch 표현식
 *
 * switch(값) {
 *     case 값1 :
 *      // 값1일 때 실행코드 break;
 *      break;
 *     case 값2 :
 *      // 값2일 대 실행코드
 *     ...
 *     default :
 *     // 모든 case문이 실행되지 않은 경우 기본실행문
 * }
 * </pre>
 */

public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);
        String menu = "=======================\n"
                    + "         자판기\n"
                    + "=======================\n"
                    + "1. 사이다 - 1000\n"
                    + "2. 콜라 - 1500\n"
                    + "3. 환타 - 1300\n"
                    + "=======================\n"
                    + "입력 : ";
        System.out.println(menu);
        String choice = sc.next();

        String name = "";
        int price = 0;

        switch (choice) {
            case "1" :
                name = "사이다";
                price = 1000;
//                System.out.println("사이다 선택 - 1000원");
                break;
            case "2" :
                name = "콜라";
                price = 1500;
//                System.out.println("콜라 선택 - 1500원");
                break;
            case "3" :
                name = "환타";
                price = 1300;
//                System.out.println("환타 선택 - 1300원");
                break;
            default :
                System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println(name + " " + price);
    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수 입력 : ");
        int score = sc.nextInt();
        char grade = ' ';

        /**
         * 학점 부여
         * - 90 ~ 100 -> A
         * - 80 ~ 89 -> B
         * - 70 ~ 79 -> C
         * - 60 ~ 69 -> D
         * - 0 ~ 59 -> F
         */

        /**
         * fall-through
         * - switch-case문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
         */
        switch (score / 10) {
            case 10 :
            case 9 :
                grade = 'A'; break;
            case 8 :
                grade = 'B'; break;
            case 7 :
                grade = 'C'; break;
            case 6 :
                grade = 'D'; break;
            default:
                grade = 'F'; break;
        }
        System.out.println(score + "점은" + grade + "학점입니다.");
    }

    /**
     * 사용자에게 정수 2개, 연산자(+ - * / %) 1개를 입력받아서
     * 정수 2개에 대해 해당 연산 결과를 출력하세요.
     *
     * > 정수 1 입력 : 30
     * > 정수 2 입력 : 20
     * > 연산자입력 (+ - * / %) : +
     * > 결과 출력 : 30 + 20 -> 50
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 1 입력 : ");
        int int1 = sc.nextInt();
        System.out.print("> 정수 2 입력 : ");
        int int2 = sc.nextInt();
        System.out.print("> 연산자 (+ - * / %) : ");
        char operator = sc.next().charAt(0);
        int result = 0;
        switch(operator) {
            case '+' :
                result = int1 + int2;
                break;
            case '-' :
                result = int1 - int2;
                break;
            case '*' :
                result = int1 * int2;
                break;
            case '/' :
                result = int1 / int2;
                break;
            case '%' :
                result = int1 % int2;
                break;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다!");
                test3();
                return; // 조기 리턴. 하위의 코드를 실행하지 않고 리턴.
            // 리턴을 하지 않으면 아래 출력문이 쌓이다가 한꺼번에 출력됨.
        }
        System.out.println("> 결과 출력 : " + int1 + operator + int2 + "->" + result);
    }
}
