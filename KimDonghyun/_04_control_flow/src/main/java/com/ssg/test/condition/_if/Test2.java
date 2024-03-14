package com.ssg.test.condition._if;

import java.util.Scanner;

/**
 * <pre>
 * 1~10 사이의 정수 한개를 입력받아
 * 홀수인지 짝수인지 확인하고, 홀수면 “홀수다.”, 짝수면 “짝수다.”출력 하세요.
 *
 * 단, 1~10사이의 정수가 아닌 경우 “ 반드시 1~10사이의 정수를 입력해야 합니다.”를 출력하세요.
 * </pre>
 */
public class Test2 {

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1에서 100사이의 정수를 하나 입력하세요 ==>");
        int num = sc.nextInt();

        String result = "";

        if (num > 0 && num <= 100) {
            if (num % 2 == 0) {
                result = "짝수를 입력하셨습니다.";
            } else {
                result = "홀수를 입력하셨습니다.";
            }
        } else {
            result = "1에서 100사이의 정수가 아닙니다.";
        }
        System.out.println(result);
    }

}