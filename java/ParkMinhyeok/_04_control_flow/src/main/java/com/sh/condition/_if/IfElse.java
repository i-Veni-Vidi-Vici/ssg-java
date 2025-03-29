package com.sh.condition._if;

import java.util.Scanner;

public class IfElse {
    Scanner sc = new Scanner(System.in);

    public void test() {
        System.out.println("정수 입력");
        int num = sc.nextInt();

        if (num % 2 != 0) {
            System.out.println("홀수");
        } else {
            System.out.println("짝수");
        }
    }

    public void test2() {
        System.out.println("성별 입력");
        char gender = sc.next().charAt(0);

        if (gender == 'M') {
            System.out.println("장난감");
        } else {
            System.out.println("장미꽃");
        }
    }

    public void test3() {
        System.out.println("> 정수 입력 :");
        int num = sc.nextInt();

        if (num != 0) {
            if (num > 0) {
                System.out.println("양수");
            } else {
                System.out.println("음수");
            }
        } else {
            System.out.println("0");
        }
    }
}
