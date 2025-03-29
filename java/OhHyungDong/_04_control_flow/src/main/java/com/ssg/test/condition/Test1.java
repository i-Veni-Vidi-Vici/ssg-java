package com.ssg.test.condition;

import java.util.Scanner;

public class Test1 {

    public void test()
    {
        Scanner scan = new Scanner(System.in);
        int result = 0;

        System.out.print("정수1 입력 : ");
        int firstNumber = scan.nextInt();
        System.out.print("정수2 입력 : ");
        int secondNumber = scan.nextInt();
        System.out.print("연산자 입력(+ - * / %) : ");
        String operator = scan.next();
        System.out.println("-------------------");

        switch (operator)
        {
            case"+":
                result = firstNumber + secondNumber;
                break;
             case"-":
                result = firstNumber - secondNumber;
                break;
             case"*":
                result = firstNumber * secondNumber;
                break;
             case"/":
                result = firstNumber / secondNumber;
                break;
             case"%":
                result = firstNumber % secondNumber;
                break;
            default :
                System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
                return;


        }
        System.out.println(firstNumber + operator + secondNumber + "=" + result);
    }

}
