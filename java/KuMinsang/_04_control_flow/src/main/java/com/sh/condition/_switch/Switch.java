package com.sh.condition._switch;

import java.util.Scanner;

/**
 * switch문
 * - 논리값이 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 * - byte, short, int, char, String, enum(상수) 사용가능
 * - boolean, long, float, double 사용불가
 *
 * switch표현식
 * switch(특정 값){
 *     case 값1 : 값1 일때 실행코드
 *      break;
 *     case 값2 : 값2 일때 실행코드
 *      break;
 *     case 값3 : 값3 일때 실행코드
 *      break;
 *     default :
 *     //모든 case문이 실행되지 않은 경우 기본 실행문

 * }
 */
public class Switch {
    public void test(){
        Scanner sc = new Scanner(System.in);
        String menu =   "==================\n"+
                        "       자판기      \n"+
                        "==================\n"+
                        "1. 사이다\n"+
                        "2. 콜라\n"+
                        "3. 환다\n"+
                        "==================\n"+
                        "입력 : \n";
        System.out.println(menu);
        /*
        String name = sc.next();

        switch(name){
            case "사이다" :
                System.out.println("사이다를 선택하셨습니다. 가격은 1000원이다");
                break;
            case "콜라" :
                System.out.println("콜라를 선택하셨습니다. 가격은 300원이다");
                break;
            case "환타" :
                System.out.println("환타를 선택하셨습니다. 가격은 6000원이다");
                break;
            default :
                System.out.println("잘못 입력 하셨습니다.");
        }
         */
        String choice = sc.next();
        String name="";
        int price=0;

        switch(choice){
            case "1" :
                name = "사이다";
                price = 300;
                break;
            case "2" :
                name = "콜라";
                price = 10000;
                break;
            case "3" :
                name = "환타";
                price = 9850;
                break;
            default :
                System.out.println("잘못 입력 하셨습니다.");
        }


        System.out.println(name + "를 선택하셨습니다. 가격은" + price + "원이다");
    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수 입력 : ");
        int score = sc.nextInt();
        char grade = ' ';   //빈문자열로 초기화

        switch (score/10){
            case 10 :
                System.out.println("A+학점");
                break;
            case 9 :
                System.out.println("A학점");
                break;
            case 8 :
                System.out.println("B+학점");
                break;
            case 7 :
                System.out.println("B학점");
                break;
            case 6 :
                System.out.println("C+학점");
                break;
            case 5 :
                System.out.println("C학점");
                break;
            case 4 :
                System.out.println("D학점");
                break;
            default:
                System.out.println("F학점");
                break;
        }
    }   //test2()

    /**
     * 사용자에게 정수 2개, 연산자 ( + - * / % ) 1개를 입력받아
     * 정수 2개에 대해 해당 연산 결과를 출력하시오
     * >정수1 입력 : 30
     * >정수2 입력 : 20
     * >연산자 입력 ( + - * / % )  : +
     * >결과 출력 : 30 +20 = 50
     *
     */

    public void test3(){
        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;
        char op;

        System.out.println(">정수1 입력 : ");
        num1 = sc.nextInt();
        System.out.println(">정수2 입력 : ");
        num2 = sc.nextInt();
        System.out.println(">연산자 입력 ( + - * / %) : ");
        op = sc.next().charAt(0);

        switch(op) {
            case '+':
                System.out.println(num1+num2);
                break;
            case '-':
                System.out.println(num1-num2);
                break;
            case '*':
                System.out.println(num1*num2);
                break;
            case '/':
                System.out.println(num1/num2);
                break;
            case '%':
                System.out.println(num1%num2);
                break;

        }



    }


}
