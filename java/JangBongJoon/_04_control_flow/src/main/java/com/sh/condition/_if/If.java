package com.sh.condition._if;

import java.util.Scanner;

public class If {
    public void test() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("굿굿굿");
        }
        if (num < 0) {
            System.out.println("음수음수음수");
        }

    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">정수입력 :");
        int num = sc.nextInt();
        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("양수 짝수");

            }
        }
        System.out.println("프로그램 종료");
    }

}

