package com.ssg.test.condition_if;

import java.util.Scanner;

public class Test1 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int num1=0;
        int num2=0;
        char oper=' ';
        int result =0;

        System.out.println("정수1 입력 : ");
        num1 = sc.nextInt();
        System.out.println("정수2 입력 : ");
        num2 = sc.nextInt();
        System.out.println("연산자 입력 (+ - * / %) : ");
        oper = sc.next().charAt(0);

        switch (oper) {
            case '+' :
                result = num1+num2;
                break;
            case '-' :
                result = num1-num2;
                break;
            case '*' :
                result = num1*num2;
                break;
            case '/' :
                result = num1/num2;
                break;
            case '%' :
                result = num1%num2;
                break;

        }
        System.out.println("----------------------");
        System.out.println(num1 + " "+ oper + " "+num2 + " = " + result);

    }
}
