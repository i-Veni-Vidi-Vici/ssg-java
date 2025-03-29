package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1~10사이의 정수 한개를 입력하시오 : ");
        int num1 = sc.nextInt();
        if (num1 > 10 || num1 < 1) {
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
            return;
        }
        if (num1 % 2 == 1) {
            System.out.println("홀수다");
        }
        else{
            System.out.println("짝수다");
        }
        }
    }