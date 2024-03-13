package com.sh.condition._switch;

import java.util.Scanner;

public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);
        String menu = "===================\n"
                    + "       자판기       \n"
                    + "===================\n"
                    + " 1. 사이다 - $ 1000\n"
                    + " 2.  콜라 - $ 1500\n"
                    + " 3.  환타 - $ 1300\n"
                    + "===================\n"
                    + "입력 : ";
        System.out.println(menu);
        String choice = sc.next(); // int 보다 String으로 쓰는 것이 더 좋음!

        //switch문 안에서 사용할 변수는 switch 블럭 밖에서 선언한다.!
        String name = ""; // 빈 문자열 초기화
        int price = 0; // 0 초기화, 초기화를 하지 않을 경우 switch문에 해당하지 않는 값을 입력했을 경우, name price 변수가 쓰이지 않아 오류가 발생할 수 있다.

        switch (choice) {
            case "1" :
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
            default :
                System.out.println("잘못 입력하셨습니다😅");
        }
        System.out.println(name + "를 선택하셨습니다. 가격은 " + price + "원입니다.");
    }

    /**
     * 학점 부여
     * - 90 ~ 100 -> A
     * - 80 ~ 89 -> B
     * - 70 ~ 79 -> C
     * - 60 ~ 69 -> D
     * - 0 ~ 59 -> F
     */

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수 입력 (0 ~ 100) : ");
        int score = sc.nextInt();
        String grade = ""; // 빈 문자열로 초기화

        /**
         * fall-through
         * switch-case 문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
         */
        switch (score / 10){
            case 10 : grade = "A"; break;
            case 9 : grade = "B"; break;
            case 8 : grade = "C"; break;
            case 7 : grade = "D"; break;
            case 6 : grade = "F";
        }
        System.out.println(score + "점은 학점 " + grade + "입니다.");
    }

    /**
     * 사용자에개 정수 2개, 연산자 (+ - * / % )1입력 받아서
     * 정수 2개에 대해 해당 연산 결과를 출력하세요.
     * > 정수 1 입력 : 30
     * > 정수 2 입력 : 20
     * > 연산자입력 (+-*|%) : +
     * > 결과 출력 : 30 + 20 -> 50
            *
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 정수 1 입력 : ");
        int num1 = sc.nextInt();

        System.out.println("> 정수 2 입력 : ");
        int num2 = sc.nextInt();

        System.out.println("> 연산자 입력 ( + - * / % ) : ");
        String operator = sc.next();

        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result + "🎀");
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            default :
                System.out.println("❗틀린 연산이야!❗");
                return ;// 조기 리턴, 하위의 코드를 실행하지 않고 현재 메소드를 호출한 곳으로 리턴 -> 밑의 코드를 실행하지 않도록 하는 예시

        }
        System.out.println("결과 출력 : " + num1 + operator + num2 + " = " + result + "🎀");
    }
}
