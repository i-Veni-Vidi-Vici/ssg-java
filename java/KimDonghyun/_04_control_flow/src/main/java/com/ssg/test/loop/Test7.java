package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        // i = 1 ~ 9 (9번)
        for(int i = 1; i < 10; i++) {
            String n = "";
            String padding = " ".repeat(9 - i);
            // i = 1, j = 1
            // i = 2, j = 1, 2
            // i = 3, j = 1, 2, 3
            for(int j = 1; j <= i; j++) {
                n += j;
            }
            // Integer.parseInt 문자열(숫자)을 int로 변환
            System.out.printf("%s%s x 8 + %d = %d\n", padding, n, i, Integer.parseInt(n) * 8 + i);
        }
    }
}
