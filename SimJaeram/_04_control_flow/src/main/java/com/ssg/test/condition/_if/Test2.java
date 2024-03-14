package com.ssg.test.condition._if;

import java.util.Scanner;

public class Test2 {
    public void test() {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        String result = "";

        System.out.print("> 1 ~ 10 사이의 정수 한개를 입력해주세요. : ");
        num = sc.nextInt();

        if ((1 <= num) && (num <= 10)) {
            if (num % 2 == 0) {
                result = "짝수";
            } else {
                result = "홀수";
            }
        } else {
            System.out.println("반드시 1 ~ 10 사이의 정수를 입력해야 합니다.");
            return;
        }

        System.out.println(result + "다.");
    }
}
