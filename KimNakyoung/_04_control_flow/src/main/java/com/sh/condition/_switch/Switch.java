package com.sh.condition._switch;

import java.util.Scanner;

/**
 * switch 표현식
 * - 논리값이 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 * - byte, shork, int, char, String(1.7부터가능), enum(상수) 사용가능
 * -boolean, long, float, double 사용불가
 *
 * switch 표현식
 *
 *
 * swith(값) {
 *     case 값1 :
 *     // 값1일 때 실행코드
 *     break;
 *     case 값2 :
 *     //값2일 때 실행코드
 *     ...
 *     default:
 *     //모든 case문이 실행되지 않은 경우 기본실행문
 *
 * }
 *
 */

// "" 안에서

public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);
        String menu = "====================\n"
                    + "       자판기\n"
                    + "====================\n"
                    + "1. 사이다 - 1000\n"
                    + "2. 콜라 - 1500\n"
                    + "3. 환타 - 1300\n"
                    + "====================\n"
                    + "번호 입력 : ";
        System.out.print(menu);
        String choice = sc.next(); // 이거하면 스캐너 오류는 안 난다
//        int choice = sc.nextInt(); // 이거 하면 정수가 아닌 실수로라도 텍스트 입력되면 오류나요
// 입력값 미스매치 잘못 입력했다고도 안나옴
        String name = ""; // 빈문자열 초기화! 선언 안 되는 경우 생각해야되서
        int price = 0; // 빈값 초기화 !

        switch (choice) {
            case  "1":
                name = "사이다";
                price = 1000;
                break;
            case "2" :
                name = "콜라";
                price = 1500;

                break;
            case "3" :
                name = "환타";
                price = 1300;
                break;
            default:
                System.out.println("잘못 입력하셨습니다."); // 여기서 name이랑 price가 선언 되지 않음
        }

        System.out.println(name + "를 선택하셨습니다." + price +"은 1000원 입니다.");

    }

    /**
     * 학점부여
     * 90 ~ 100 -> A
     * 80 ~ 89 -> B
     * 70 ~ 79 -> C
     * 60 ~ 69 -> D
     * 0 ~ 59 -> F
     */


    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 점수 입력 (0 ~ 100) : ");
        int score = sc.nextInt();
        char grade = ' '; // 빈문자열로 초기화

        /**
         *
         * fall-through
         * - Switch-case문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
         *
         */


        switch(score / 10) {
            case 10:
            case 9: grade = 'A'; break;
            case 8: grade = 'B'; break;
            case 7: grade = 'C'; break;
            case 6: grade = 'D'; break;
            default: grade = 'F';

        }
        //Alt + Shift + 클릭

        System.out.println(score + "점은 " + grade + "학점입니다.");

    }

    /**
     * 사용자에게 정수2개 연산자(+ - * / %) 1개를 입력받아서
     * 정수 2개에 대해 해당 연산 결과를 출력하세요
     * > 정수1 입력 : 30
     * > 정수2 입력: 20
     * > 연산자입력 ( + - * / %) : +
     * > 결과 출력 : 30 + 20 = 50
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수1 입력 : " );
        int num1 = sc.nextInt();
        System.out.print("> 정수2 입력 : " );
        int num2 = sc.nextInt();
        System.out.println("> 연산자 입력(+ - * / %) : " );
        char operator = sc.next().charAt(0);
        int result = 0;


        switch (operator) {
            case '+' : result = num1 + num2; break;
            case '-' : result = num1 - num2; break;
            case '*' : result = num1 * num2; break;
            case '/' : result = num1 / num2; break;
            case '%' : result = num1 % num2; break;
            default:
                System.out.println("잘못 입력하셨습니다.");
                return; // 원래 void하면 맨 마지막에 return인데 조기 리턴, 하위의 코드를 실행하지 않고 리턴

        }
        System.out.println("결과출력 : " +num1 +" "+ operator +" "+ num2 +" -> " + result );

    }
}
