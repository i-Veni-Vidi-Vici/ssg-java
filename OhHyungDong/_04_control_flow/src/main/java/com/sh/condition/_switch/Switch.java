package com.sh.condition._switch;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * switch문
 * - 논리값이 아닌 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식을 작성해야 함.
 * - byte, short, int, char, String, enum(상수) 사용 가능
 * - long, float, double,Boolean -> 사용불가
 *
 * switch 표현식
 *
 * switch(값,변수){
 *     case 값1 :
 *     //값1일 때 실행 코드
 *      break;
 *     case 값2 :
 *     // 값2일 때 실행 코드
 *      break;
 *     ...
 *     default :
 *      //모든 case문이 실행되지 않은 경우 기본실행문
 *
 *
 *
 * }
 */


public class Switch
{

    public void test()
    {
        Scanner sc = new Scanner(System.in);
        String menu = "===================\n"
                      +         "자판기\n"
                      +"===================\n"
                      +"1.사이다 - 1000원\n"
                      +"2.콜라 - 1500원\n"
                      +"3,환타 - 1300원\n"
                      +"===================\n"
                      +"번호 입력 : ";
        System.out.println(menu);
        String choice= sc.next();

        //switch문 안에서 사용할 변수는 switch블럭 밖에서 선언한다.
        String name = ""; //빈 문자열 초기화
        int price = 0; // 0 초기화
        switch (choice)
        {
            case "1" :
                name = "사이다";
                price = 1000;

                break;
            case "2" :
                name = "콜라";
                price = 1500;
                break;

            case "3" :
                name = "환다";
                price = 1300;
                break;
            default :
                System.out.println("잘못 입력하셨습니다.");

        }
        System.out.println(name + "를 선택하셨습니다." + "가격은 " + price + "원입니다.");

    }

    public void test2()
    {
        //점수를 받아서 학점 부여  100-90 A 80~89 B - 70-79 C 60 -69 D 나머지 f

            Scanner scan = new Scanner(System.in);
            System.out.print("점수 입력 : ");
            int score = scan.nextInt();
            char grade ;

        /**
         * fall - through
         * switch - case문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
         */
        switch (score/ 10)
            {
                case 10:
                case 9:
                    grade = 'A';
                    System.out.println(score + "점은 학점 " + grade + "입니다. ");
                    break;

                case 8:
                    grade = 'B';
                    System.out.println(score + "점은 학점 " + grade + "입니다. ");
                    break;
                case 7:
                    grade = 'C';
                    System.out.println(score + "점은 학점 " + grade + "입니다. ");
                    break;
                case 6:
                    grade = 'E';
                    System.out.println(score + "점은 학점 " + grade + "입니다. ");
                    break;

                default:
                    grade = 'F';
                    System.out.println(score + "점은 학점 " + grade + "입니다. ");
                    break;

            }


    }

    //정수 2개, 연산자 1개를 입력 받아
    public void test3()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("첫번째 정수 : ");
        int a = scan.nextInt();
        System.out.print("두번째 정수 : ");
        int b = scan.nextInt();
        System.out.println("기호 입력 : ");
        String symbol = scan.next();

        switch (symbol){
            case "+":
                System.out.println("결과 출력 : " + a + "+"+ b + "->" + (a+b)); break;

            case "-":
                System.out.println("결과 출력 : " + a + "-" + b + "->" + (a-b)); break;

            case "*":
                System.out.println("결과 출력 : " + a + "*" + b + "->" + (a*b)); break;

            case "/":
                System.out.println("결과 출력 : " + a + "/" + b + "->" + (a/b)); break;

            default :
                System.out.println("기호를 다시 입력하세요.");
                return; // "조기 리턴" 하위 코드 실행시키지 않고 return 시켜버림

        }
    }


}
