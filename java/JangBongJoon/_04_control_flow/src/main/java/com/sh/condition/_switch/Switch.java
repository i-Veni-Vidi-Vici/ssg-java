package com.sh.condition._switch;


import java.util.Scanner;

/*
switch 표현식
switch(값){
-논리값이 값으로써 분기처리하는 제어문
값 자리에는 변수 또는 값으로 처리되는 계산식 작성
byte,short,int , char, String, enum(상수) 사용가능
long, float, double
boolean, long ,float,double 사용불가
    case 값1 : 값1일때 실행코드
    break;
    case 값2 :
    값2일때 실행코드
    break;
    default:
    모든 CASE문이 실행되지 않은 경우 기본실행문
 }
 */
public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);
        String menu = """
                ==============
                    자판기
                ================
                1.사이다
                2.콜라
                3.환타
                =================입력 :\s""";
        System.out.println(menu);
        String choice = sc.next();
        //switch문 안에서 사용할 변수는 switch블럭 밖에서 선언한다.
        String name = ""; //빈문자열로 초기화를 해야한다.
        int price = 0;

        switch(choice){
            case "1":
                name = "사이다";
                price = 1000;
                break;
            case "2":
                name = "콜라";
                price = 1500;
                System.out.println("콜라를 선택하셨습니다. 가격은 1500원입니다");
                break;
            case "3":
                name = "환타";
                price = 1300;
                System.out.println("환타를 선택하셨습니다. 가격은 1300원입니다.");
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println(name + "를 선택하셨습니다. 가격은 " +
                price + "원입니다.");
    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수 입력: ");
        int score = sc.nextInt();
        char grade = switch (score / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            case 5 -> 'F';
            default -> ' '; // 빈 문자열로 초기화

        };

    }

//    /*
//    사용자에게 정수 2개, 연산자(+ - * / %) 1개
//    정수2개에 대해 해당 연산 결과를 출력하세요
//
//    >정수1 입력 :30
//    >정수2 입력 :20
//    >연산자입력(+-*/ %) : +
//    >결과 출력 :30 + 20 -> 50
//     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 입력:");
        int user1 = sc.nextInt();
        System.out.print("정수2 입력:");
        int user2 = sc.nextInt();
        System.out.println("연산자 입력");
        String Cal = sc.next();
        switch (Cal) {
            case "+" :
                int sum = user1 + user2;
                System.out.println(user1 + "+" + user2 + "=" + sum);
                break;
            case "-":
                int minus = user1 - user2;
                System.out.println(user1 +"-" + user2 +"= "+ minus);
                break;
            case "*":
                int mul = user1 * user2;
                System.out.println(user1 + "*" + user1 + "=" + mul);
                break;
            case "/":
                int div = user1 / user2;
                System.out.println(user1 + "/" + user1 + "=" + div);
                break;
            case "%":
                int mod = user1 % user2;
                System.out.println(user1 + "*" + user1 + "=" + mod);
                break;
            default:
                System.out.println("값을 제대로 입력하시오.");
                return; //조기 리턴. 하위의 코드를 실행하지 않고 리턴.
            
        }
    }
}

