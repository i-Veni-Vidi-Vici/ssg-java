package com.ssg.test.operator.logical;

public class App {

/*
금요일 과제1
 */



    public static void main (String[] args) {


// 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println("n은 1~100사이의수가 " + (n >= 1 && n <= 100 ? " 맞다" : "아니다"));
// 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println("ch1은 영어 대문자의수가 " + ((ch1 >= 65 && ch1 <= 90) ? "맞다" : "아니다"));

// 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println("ch1은 영어 대문자의수가 " + ((ch2 >= 97 && ch1 <= 122) ? "맞다" : "아니다"));

// 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        System.out.println("yn이 대소문자 관계없이 y가 " + (( yn == 89 || yn == 121) ? "맞다" : "아니다"));

// 문자 k가 영문자인지 검사
        char k = 'z';
        System.out.println("k가 영문자가 " + (( (k <= 65 && k <= 90) || (k <= 97 && k <= 122)) ? "맞다" : "아니다"));

    }
}
