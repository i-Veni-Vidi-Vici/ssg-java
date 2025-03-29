package com.sh.condition._switch;

import java.util.Scanner;

/**
 * <pre>
 *     switch문
 *     - 논리 값이 값으로써 분기 처리하는 제어문
 *     - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 *     - byte, short, int, char, string, enum(상수) 사용 가능
 *     - boolean, long, float, double 사용 불가
 *
 *     switch 표현식
 *
 *     switch(값) {
 *         case 값1 :
 *              값1 일때 실행코드;
 *              break;
 *         case 값2 :
 *              값2 일때 실행코드;
 *              break;
 *         case 값3 :
 *              값3일때 실행코드;
 *              break;
 *         ....
 *         default :
 *              모든 case문이 실행되지 않은 경우 기본 실행문
 *     }
 * </pre>
 */
public class Switch {
    public void test(){
        Scanner sc = new Scanner(System.in);
        
        //switch문 안에서 사용할 변수는 switch 블럭 밖에서 선언한다.
        
        
        String menu = "=========================\n"
                    + "\t\t자판기\n"
                    + "=========================\n"
                    + "\t사이다\t 1000\n"
                    + "\t 콜라\t 1500\n"
                    + "\t 환타\t 1500\n"
                    + "=========================\n"
                    + "입력 : ";

        System.out.print(menu);

        String choice = sc.next();
        
        String name = null;
        int price = 0;
        
        switch (choice){
            case "1" :
                name = "사이다";
                price = 1000;
                break;
            case "2라" :
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

        System.out.println(name + "를 선택하셨습니다. 가격은 " + price + "원 입니다.");
    }

    // 학점 등급 부여
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 점수을 입력하세요. : ");
        int score = sc.nextInt();
        char grade = ' ';

        switch (score / 10) {
            case 9: grade = 'A'; break;
            case 8: grade = 'B'; break;
            case 7: grade = 'C'; break;
            case 6: grade = 'D'; break;
            default: grade = 'F';
        }

        System.out.println(score + "점은 " + grade + " 학점입니다.");
    }

    /**
     * <pre>
     *     사용자에게 정수 2개, 연산자( +, -, *, /, % ) 1개를 입력받아서
     *     정수 2개에 대해 해당 연산 결과를 출력
     * </pre>
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);

        System.out.print("> 정수1 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("> 정수2 입력 : ");
        int num2 = sc.nextInt();
        System.out.print("> 연산자 입력( + - * / % ) : ");
        char op = sc.next().charAt(0);

        int result = 0;

        switch (op){
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
            case '/' :
                result = num1 / num2;
                break;
            case '%' :
                result = num1 % num2;
                break;
            default:
                System.out.println("오류");
        }
        System.out.println("결과 출력 : " + num1 + op + num2 + " -> " + result);
    }
}
