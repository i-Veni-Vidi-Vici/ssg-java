package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);

        System.out.print("1~10사이 정수 입력: ");
        String next = sc.next();
        int value = 0;

        try {
            value = Integer.parseInt(next);
        } catch (NumberFormatException e) {
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
            return;
        }

        if (!(value >= 1 && value <= 10)) {
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
            return;
        }

        System.out.println("결과: "+((value%2 == 0)? "짝수": "홀수"));



    }
}
