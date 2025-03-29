package com.sh.condition._switch;

import java.util.Scanner;

/**
 * <pre>
 * switch문
 * - 논리값이 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 * - 사용 가능 : byte, short, int, char, String(1.7부터 가능), enum (상수)
 * - 사용 불가능 : boolean, long, float, double
 *
 * switch 표현식
 *
 * switch(값) {
 *     case 값1
 *     // 값1일때 실행코드
 *     break,
 *     case 값2
 *     // 값2일때 실행코드
 *       break,
 *       ...
 *       default;
 *       // 모든 case문이 실행되지 않은 경우 기본실행문
 * }
 * </pre>
 */


public class Switch {
    public void test() {
        Scanner sc =new Scanner(System.in);
        String menu = "===================\n"
                    + "       자판기\n"
                    + "===================\n"
                    + "1. 사이다 1000\n"
                    + "2. 콜라 1500\n"
                    + "3. 환타 1300\n"
                    + "===================\n"
                    + "번호 입력 : ";
        System.out.println(menu);
        String choice = sc.next();
        // switch문 안에서 사용할 변수는 switch 블럭 밖에서 선언
        String name = ""; // 빈 문자열 초기화
        int price = 0; // 0 초기화

        switch (choice) {
            case "1" :
                name = "사이다";
                price = 1000;
                break;
            case  "2" :
                name = "콜라";
                price = 1500;
                break;
            case "3" :
                name = "환타";
                price = 1300;
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }

        System.out.println(name + "를 선택하셨습니다. 가격은 " + price +"원입니다.");
    }

    /**
     * 학점부여
     * - 90 ~100 : A
     * - 80 ~ 89 : B
     * - 70 ~ 79 : C
     * - 60 ~ 69 : D
     * - 0 ~ 59 : F
     */

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수 입력 : ");
        int score = sc.nextInt();
        char grade = ' '; // 빈문자열로 초기화 (스페이스 안누르면 오류)

        /**
         * fall-through
         * switch-case 문에서 break를 생략하면 하위 case문으로 이어서 진행됨
         */

        switch (score/10) {
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
     * 사용자에게 정수 2개, 연산자(+-/*%) 1개를 입력받아서
     * 정수 2개에 대해 해당 연산 결과 출력
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수1 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("> 정수2 입력 : ");
        int num2 = sc.nextInt();
        System.out.print("> 연산자 입력 (+ - * / %) : ");
        String str = sc.next();
        int result = 0;

        switch (str) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다.");
                return; // 조기리턴 : 하위의 코드를 실행하지 않고 리턴 (원래는 맨마지막 "> 결과출력" 밑에 있음)
        }
        System.out.println("> 결과 출력 : " + num1 + " " + str + " " + num2 + " " + "->" + " " + result);
    }
}
