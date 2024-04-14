package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1~10 사이의 정수 한 개를 입력해주세요.");
        int num = sc.nextInt();
        if (num > 10) {
            System.out.println("반드시 1~10 사이의 정수를 입력해야합니다.");
            return;
        }
        System.out.println(num % 2 == 0 ? "짝수입니다" : "홀수입니다.");
    }
}
