package com.ssg.test.condition._if._if_Re;

import java.util.Scanner;

public class Test2 {

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1에서 10사이의 정수를 하나 입력하세요 : ");
        int num = sc.nextInt();

        String result = "";

        if (num > 0 && num <= 10) {
            if (num % 2 == 0) {
                result = "짝수를 입력하셨습니다.";
            } else {
                result = "홀수를 입력하셨습니다.";
            }
        } else {
            result = "반드시 1 ~ 10사이의 정수를 입력해야 합니다.";
        }
        System.out.println(result);
    }

}