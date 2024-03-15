package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10 사이의 정수 한개를 입력하시오 : ");
        int num = sc.nextInt();

        if (num < 1 || num > 10) {
            System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다. 프로그램을 종료합니다.");
            return;
        }

        if (num % 2 == 0) {
            System.out.println("짝수");
        }
        else{
            System.out.println("홀수");
        }
    }
}
