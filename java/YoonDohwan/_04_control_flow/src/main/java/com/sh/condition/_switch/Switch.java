package com.sh.condition._switch;
import java.util.Scanner;
/**
 * switch문
 * 논리값이 값으로써 분기처리하는 제어문
 * 값자리에는 변수 또는 값으로 처리되는 계산식 작성
 * -byte,short,int,char,String(1.7부터),enum 가능
 * -boolean,long,float,double 불가능
 * switch 표현식
 *
 * switch(값){
 *     case 값1 : 값1일때 실행코드 break;
 *     case 값2 : 값2일때 실행코드 break;
 *     ...
 *     default://모든 case문이 실행되지 않은 경우 기본실행문
 *
 * }
 *
 */

public class Switch {
    public void test() {
        Scanner sc = new Scanner(System.in);
        String menu = "====================\n"
                +"            자판기\n"
                +"====================\n"
                +"1.사이다 - 1000\n"
                +"2.콜라 - 1500\n"
                +"3.환타 - 1300\n"
                +"====================\n"
                +"입력 : ";
        System.out.println(menu);
        String choice = sc.next();
        String name="";
        int price=0;
        switch(choice){
            case "1" :
                name="사이다";
                price=1000;
                break;
            case "2" :
                name="콜라";
                price=1500;
                break;
            case "3" :
                name="환타";
                price=1300;
                break;
            default :
                System.out.println("잘못 입력하셨습니다.");

        }
        System.out.println(name +"를 선택하셨습니다. 가격은 "+ price +"원입니다.");
    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요 : ");
        int score = sc.nextInt();
        char grade = ' ';
        /**
         * switch-case문에서 break를 생략하면, 하위 case문을 이어서 진행된다.
         */
        switch(score/10){
            case 10 : grade='A';break;
            case 9 : grade='A';break;
            case 8 : grade='B';break;
            case 7 : grade='C';break;
            case 6 : grade='D';break;
            default : grade='F';break;

        }
        System.out.println(score + "점은" + grade +"학점입니다.");
    }

    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1번째 정수를 입력하시오 : ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.println("2번째 정수를 입력하시오 : ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.println("기호를 입력하시오(+ - * / %)");
        char arc = sc.nextLine().charAt(0);
        int num3=0;
        switch(arc){
            case '+' : num3 = num1 + num2 ;break;
            case '-' : num3 = num1 - num2 ;break;
            case '*' : num3 = num1 * num2 ;break;
            case '/' : num3 = num1 / num2 ;break;
            case '%' : num3 = num1 % num2; break;
            default :
                System.out.println("연산자를 잘못 입력 하셨습니다.");
                return;//조기 리턴,하위의 코드를 실행하지 않고 리턴
        }
        System.out.println("결과출력 : " + num1 + arc + num2 +"->"+num3 );
    }
}
