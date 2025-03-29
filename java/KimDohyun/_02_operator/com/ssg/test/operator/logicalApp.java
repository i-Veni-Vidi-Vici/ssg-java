package com.ssg.test.operator;

public class logicalApp {
    public static void main(String[] args){
        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';

        // 문자 k가 영문자인지 검사
        char k = 'z';
        // 정수 n이 1부터 100사이의 수인지 검사
        if (n >= 1 && n <= 100) {
            System.out.println("n은 1부터 100 사이의 수입니다.");
        } else {
            System.out.println("n은 1부터 100 사이의 수가 아닙니다.");
        }

        // 문자 ch1이 영어 대문자인지 검사
        if (ch1 >= 'A' && ch1 <= 'Z') {
            System.out.println("ch1은 영어 대문자입니다.");
        } else {
            System.out.println("ch1은 영어 대문자가 아닙니다.");
        }

        // 문자 ch2가 영어 소문자인지 검사
        if (ch2 >= 'a' && ch2 <= 'z') {
            System.out.println("ch2는 영어 소문자입니다.");
        } else {
            System.out.println("ch2는 영어 소문자가 아닙니다.");
        }

        // 문자 yn이 대소문자 관계없이 y인지 검사
        if (yn == 'Y' || yn == 'y') {
            System.out.println("yn은 대소문자 관계없이 'y'입니다.");
        } else {
            System.out.println("yn은 'y'가 아닙니다.");
        }

        // 문자 k가 영문자인지 검사
        if ((k >= 'A' && k <= 'Z') || (k >= 'a' && k <= 'z')) {
            System.out.println("k는 영문자입니다.");
        } else {
            System.out.println("k는 영문자가 아닙니다.");
        }

    }
}
