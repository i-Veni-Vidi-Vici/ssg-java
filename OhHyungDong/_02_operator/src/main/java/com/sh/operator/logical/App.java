package com.sh.operator.logical;


public class App {
    public static void main(String[] args) {
        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println(n>=1 && n<=100);

// 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println('G' == 71);

// 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println(ch2 == 103);

// 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        System.out.println(yn == 89 || yn==121);
// 문자 k가 영문자인지 검사
        char k = 'z';
        System.out.println(k == 90 && k == 122);

    }
}

