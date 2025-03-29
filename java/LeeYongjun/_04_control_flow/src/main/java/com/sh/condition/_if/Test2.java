package com.sh.condition._if;

import java.util.Scanner;

public class Test2 {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 1~10사이의 정수 입력 :");
        int num = sc.nextInt();

        if (num >= 1) {
            if (num <= 10) {
                if (num % 2 == 0) {
                    System.out.println("짝수다.");
                } else {
                    System.out.println("홀수다.");
                }
            }
            else {
                System.out.println("반드시 1~10사이의 정수를 입력해야합니다.");
            }
        }
    }
}