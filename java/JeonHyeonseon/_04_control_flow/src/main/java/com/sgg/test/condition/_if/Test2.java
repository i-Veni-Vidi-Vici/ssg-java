package com.sgg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 입력(1 ~ 10) :");

        int num = sc.nextInt();

        if(num < 1 || num > 10){
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
        }
        else if(num % 2 == 0) {
            System.out.println("짝수다");
        }
        else if(num % 2 != 0) {
            System.out.println("홀수다");
        }
    }
}
