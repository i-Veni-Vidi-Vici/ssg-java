package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++){
            String a = "";
            // i=1, j=1
            // i=2, j=1 2
            // i=3, j=1 2 3
            for (int j = 1; j <= i; j++){
                a += j;
//                a += String.valueOf(j); 도 가능(String.valueOf() : 문자열로 변환)
            }
            // padding 여백문자
            // i=1, padding=8
            // i=2, padding=7
            // i=3, padding=6 ...(규칙: 두 수의 합이 9)
            String b = " ".repeat(9 - i);
            // Integer.parseInt 문자열을 int로 변환
            System.out.printf("%s%s x 8 + %d = %d\n", b, a, i, (Integer.parseInt(a) * 8 + i));
        }
    }
}
