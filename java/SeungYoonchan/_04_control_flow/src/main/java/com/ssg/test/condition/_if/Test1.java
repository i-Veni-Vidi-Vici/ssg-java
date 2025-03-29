package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test(){
        Scanner sc = new Scanner(System.in);

        System.out.print("> 정수1 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("> 정수2 입력 : ");
        int num2 = sc.nextInt();
        System.out.print("> 연산자 입력( + - * / % ) : ");
        char op = sc.next().charAt(0);
        System.out.println("-------------------------------------");
        int result = 0;

        if(!(num1 < 0 || num2 < 0)){    // num1 또는 num2가 음수가 아니라면 조건문 실행
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
                default:    // 5가지 case 이외는 모두 잘못 입력으로 구분
                    System.out.println("음수 또는 연산자 이외의 문자가 입력되었습니다. 프로그램을 종료합니다.");
                    return;
            }
        }
        else {  // if문에 해당하지 않으면 음수이므로 경고문 표시
            System.out.println("음수 또는 연산자 이외의 문자가가 입력되었습니다. 프로그램을 종료합니다.");
            return;
        }

        System.out.println("결과 출력 : " + num1 + op + num2 + " -> " + result);
    }
}

