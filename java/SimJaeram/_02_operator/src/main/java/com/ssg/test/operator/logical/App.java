package com.ssg.test.operator.logical;

public class App {
    public static void main(String[] args) {

        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println((1 < n) && (n < 100));                                       // true

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println((65 <= ch1) && (ch1 <= 90));                                 // true

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println((97 <= ch2) && (ch2 <= 122));                                // true

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        System.out.println((yn == 89) || (yn == 121));                                  // true

        // 문자 k가 영문자인지 검사
        char k = 'z';
        System.out.println(((65 <= k) && (k <= 90)) || ((97 <= k) && (k <= 122)));      // true
    }
}
