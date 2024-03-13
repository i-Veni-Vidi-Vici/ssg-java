package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int result;
        System.out.print("정수1 입력 : ");
        int num1=sc.nextInt();

        System.out.print("정수2 입력 : ");
        int num2=sc.nextInt();

        System.out.print("연산자 입력 (+ -  / %) : ");
        char ch=sc.next().charAt(0);

        System.out.println("----------------------------");

        if(ch=='+')
        {
            result=num1+num2;
        }
        else if(ch=='-')
        {
            result=num1-num2;
        }
        else if (ch=='*')
        {
          result=num1*num2;
        }
        else if(ch=='/')
        {
            result=num1/num2;
        }
        else if(ch=='%') {
            result = num1 % num2;
        }
        else {
            System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다");
            return;
        }
        System.out.println(num1+" + "+num2+" = "+result);
    }
}
