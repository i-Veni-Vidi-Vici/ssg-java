package com.sh.condition_switch;

import java.util.Scanner;

/**
 * Switch 표현식
 * - 논리값이 값으로써 분기처리하는 제어문
 * - 값 자리에는 변수 또는 값으로 처리되는 계산식 작성
 * - byte, short, int, char, String, enum(상수) 사용가능
 * - long, boolean, float, double 사용불가
 * switch(값){
 *     case 값1 : 값1일때 실행코드
 *     break;
 *     case 값2 :
 *     // 값2 일때 실행코드
 *     break;
 *     ....
 *     default:
 *     // 모든 case문이 실행되지 않은 경우 기본 실행문
 * }
 */
public class Switch {
    public void test(){
        Scanner sc = new Scanner(System.in);
        String menu = "==================\n" +
                    "자판기\n"+
                    "=================\n"+
                    "1. 사이다 - 1000\n"+
                    "2. 콜라 - 1500\n"+
                    "3. 환타 - 1300\n"+
                    "=================\n"+
                    "번호 입력 : ";
        System.out.println(menu);
        String number = sc.next();
        switch(number){
            case "1" :
                System.out.println("사이다를 선택하셨습니다. 1000원입니다.");
                break;
            case "2" :
                System.out.println("콜라를 선택하셨습니다. 1500원입니다.");
                break;
            case "3" :
                System.out.println("환타를 선택하셨습니다. 1300원입니다.");
                break;
            default :
                System.out.println("잘못 입력하셨습니다.");
        }

    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 점수 입력 : ");
        int score = sc.nextInt();
        char grade = ' '; // 빈 문자열로 초기화
        // fall-through : switch-case문에서 break를 생략하면, 하위 case문으로 이어서 진행된다.
        switch(score / 10) {
            case 10:
                grade = 'A'; break;
            case 9:
                grade = 'A'; break;
            case 8:
                grade = 'B'; break;
            case 7:
                grade = 'C'; break;
            case 6:
                grade = 'D'; break;
            default:
                grade = 'F'; break;

        }
        System.out.println(score + "점은" + grade + "학점입니다.");
    }

    /**
     * 사용자에게 정수 2개, 연산자(+ - * / %) 1개를 입력받아서
     * 정수 2개에 대해 해당 연산 결과를 출력하세요
     */
    public void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수1 입력 : ");
        int num1 = sc.nextInt();
        System.out.println("정수2 입력 : ");
        int num2 = sc.nextInt();
        System.out.println("연산자 입력 : ");
        char x = sc.next().charAt(0);
        int result = 0;
        switch(x)
        {
            case '+' :
                result = num1 + num2;
            case '-' :
                result = num1 - num2;
            case '*' :
                result = num1 * num2;
            case '/' :
                result = num1 / num2;
            case '%' :
                result = num1 % num2;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다.");
                return; // 조기 리턴. 하위의 코드를 실행하지 않고 리턴.
        }
        System.out.println("결과 출력 : " + num1 + x + num2 + "=" + result);
    }
}
