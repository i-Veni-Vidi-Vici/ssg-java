package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        int num3=0;
        System.out.print("정수 1 입력: ");
        int num1 = sc.nextInt();
        if(num1<0){
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        sc.nextLine();
        System.out.print("정수2 입력 : ");
        int num2 = sc.nextInt();
        sc.nextLine();
        if(num2<0){
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        System.out.print("연산자 입력 (+ - * / %) : ");
        char operator = sc.nextLine().charAt(0);
        System.out.println("--------------------");
        if(operator=='+') {
            num3 = num1 + num2;
        }
            else if(operator=='-'){
                num3=num1-num2;
            }
            else if(operator=='*'){
                num3=num1*num2;
            }
            else if(operator=='/'){
                num3=num1/num2;
            }
            else if(operator=='%'){
                num3=num1%num2;
            }
            else{
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        System.out.println(num1 + " "+operator+" " + num2 + " = " + num3);
    }
}
