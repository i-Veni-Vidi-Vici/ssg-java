package com.sh.condition._if;

import java.util.Scanner;

public class If {
    Scanner sc = new Scanner(System.in);
    public void test() {

        System.out.println("정수 입력");

        int num = sc.nextInt();
        // 짝수 일때
        if (num % 2 == 0) {
            System.out.println("짝수");
        }
        if (num < 0) {
            System.out.println("음수");
        }
    }
    public void test2() {
        System.out.println("> 정수 입력 :");
        int num = sc.nextInt();

        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("양수 & 짝수");
            }
        }
        System.out.println("프로그램 종료");
    }
}
