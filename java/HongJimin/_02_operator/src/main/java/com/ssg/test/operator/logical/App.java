package com.ssg.test.operator.logical;

public class App {
    public static void main(String[] args) {
        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        System.out.println(n >= 1 && n<=100 ? "n은 1과 100 사이의 숫자입니다!" : "n은 1과 100사이에 없는 숫자입니다ㅜ");

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        System.out.println( ch1 >= 'A' && ch1 <= 'Z' ? "ch1은 대문자입니다!" : "ch1은 대문자가 아닙니다!");

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        System.out.println( ch2 >= 'a' && ch2 <= 'z' ? "ch2는 소문자입니다!" : "ch2는 소문자가 아닙니다!");

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'y';
        System.out.println( yn == 'Y' || yn =='y' ? "yn은 알파벳 Y입니다!" : "yn은 알파벳 Y가 아닙니다!");

        // 문자 k가 영문자인지 검사
        char k = 'a';
        System.out.println( (k >= 'A' && k <= 'Z') || (k >= 'a' && k <= 'z') ? "k는 영문자입니다!" : "k는 영문자가 아닙니다!");
    }
}
