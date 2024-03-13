package com.sh.condition._if;

import java.util.Scanner;

public class ifElse {
    public void nd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력: ");
        int num = sc.nextInt();
        if (num % 2 == 1) {

        }
    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        String sex = sc.nextLine();
        if (sex.equals("M")) {
            System.out.println("장난감");
        } else System.out.println("장미꽃");
    }

    public void test3() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input != 0) {
            if (input > 0) {
                System.out.println("양수");
            }else System.out.println("음수");
        } else System.out.println("0");
    }


}
