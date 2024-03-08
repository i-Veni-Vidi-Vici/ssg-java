package com.sh.operator.logical;


public class App {
    public static void main(String[] args) {
        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println(n>=1 && n<=100); // True 값이 나오면 1과 100사이에 있는 것.

// 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println(ch1>= 65 && ch1<= 90); //대문자의 아스키 코드값은 65이상 90이하기 때문에 값이 True가 나오면 대문자

// 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println(ch2>= 97 && ch2<=122); //소문자의 아스키 코드값인 97이상 122이하기 때문에 값이 True가 나오면 소문자 

// 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        System.out.println(yn == 89 || yn==121); // true 값이 나오면 소문자이거나 대문자이기 때문에 대소문자 관계없이 Y라고 할 수 있음.
// 문자 k가 영문자인지 검사
        char k = 'z';
        System.out.println((k >= 65 && k<=90) || (k>=97 && k<= 122));
        // true 값이 나오면 k값은 소문자나, 대문자 아스키 코드값에 속하기 때문에 영문자라고 할 수 있음.

    }
}

