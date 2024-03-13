package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1~10 사이의 정수를 입력: ");
        int num = sc.nextInt(); // 정수

        if(num>0 && num<=10) {
            if (num % 2 == 1) {
                System.out.println("홀수다.");
            } else {
                System.out.println("짝수다.");
            }
        } else
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
    }
}
