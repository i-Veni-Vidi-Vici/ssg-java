package com.ssg.test.operator.logical.app;

public class TestLogicalOperatorApp {
    public static void main(String[] args){
        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println("정수 n이 1~100 사이 수인가? : " + (n>=1 && n<=100));
        System.out.println("n : " + n);
        System.out.println();

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println("문자 ch1이 영어 대문자인가? : " + (ch1 >= 65 && ch1 <= 90));     // ascii code 표에서 영어 대문자는 'A' = 65 ~ 'Z' = 90
        System.out.println("ch1 : " + ch1);
        System.out.println();

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println("문자 ch2가 영어 소문자인가? : " + (ch2 >= 97 && ch2 <= 122));    // ascii code 표에서 영어 소문자는 'a' = 97 ~ 'g' = 122
        System.out.println("ch2 : " + ch2);
        System.out.println();

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        System.out.println("문자 yn이 대소문자 관계없이 y인가? : " + (yn == 89 || yn == 121));      // ascii code 표에서 'y' = 89, 'Y' = 121
        System.out.println("yn : " + yn);                                                   // 둘 중 하나만 만족하면 True 반환
        System.out.println();

        // 문자 k가 영문자인지 검사
        char k = 'z';
        System.out.println("문자 k가 영문자인가? : " + ((k >= 65 && k <= 90) || (k >= 97 && k <= 122)));
        // k가 ascii code 대문자 'A'~'Z' 즉, 65~90 사이를 만족하거나,
        // k가 ascii code 소문자 'a'~'z' 즉, 97~122 사이 둘 중 하나만 만족하면 True 반환
        System.out.println("k : " + k);
        System.out.println();

    }
}
