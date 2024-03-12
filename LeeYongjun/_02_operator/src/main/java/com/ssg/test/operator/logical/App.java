package com.ssg.test.operator.logical;

public class App {

    public static void main(String[] args) {
        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println("정수 " + n + "이 1~100 사이의 수인가? : " + (n >= 1 && n <= 100));

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println("문자 " + ch1 + "이 영어 대문자인가? : " + (ch1 >= 65 && ch1 <= 90));

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println("문자 " + ch2 + "가 영어 소문자인가? : " + (ch2 >= 97 && ch2 <= 122));

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        System.out.println("문자 " + yn + "이 대소문자 관계없이 y인가? : " + (yn == 'y' || yn == 'Y'));

        // 문자 k가 영문자인지 검사
        char k = 'z';
        System.out.println("문자 " + k + "가 영문자인가? : " + ((k >= 65 && k <= 90) || (k >= 97 && k <= 122)));
    }
}