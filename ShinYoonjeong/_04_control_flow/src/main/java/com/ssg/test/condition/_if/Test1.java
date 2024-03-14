package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test1 {
    public void test(){
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
                result = num1 + num2; break;
            case '-' :
                result = num1 - num2; break;
            case '*' :
                result = num1 * num2; break;
            case '/' :
                result = num1 / num2; break;
            case '%' :
                result = num1 % num2; break;
            default:
                System.out.println("연산자를 잘못 입력하셨습니다.");
                return; // 조기 리턴. 하위의 코드를 실행하지 않고 리턴.
        }
        System.out.println(">출력 결과 " + num1 + x + num2 + "=" + result);
    }
}
