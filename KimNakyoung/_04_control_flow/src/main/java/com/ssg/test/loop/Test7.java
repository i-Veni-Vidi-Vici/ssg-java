package com.ssg.test.loop;

/**
 *
 * 반복문 문제 7
 *
 */

public class Test7 {


    public static void main(String[] args) {
        int num = 0;

        for (int i = 1; i < 9; i++) {
            num = num * 10 + i; // 왼쪽 수 규칙
            int result = num * 8 + i;
            String padding = " ".repeat(9-i); // 피라미드 출력
            System.out.println(padding + num + " x 8 + " + i + " = " + result );
        }
    }
}
