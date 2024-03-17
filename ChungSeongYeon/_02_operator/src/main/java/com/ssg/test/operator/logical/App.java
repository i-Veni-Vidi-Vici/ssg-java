package com.ssg.test.operator.logical;

public class App {
    public static void main(String[] args){

        // 정수 n이 1부터 100사이의 수인지 검사
        int n = 55;
        String nIsWhat = (n >= 1 && n <= 100) ? "정수 n은 1부터 100 사이의 수입니다." : "정수 n은 1부터 100 사이의 수가 아닙니다.";
        System.out.println(nIsWhat);
//        int n = 55;
//        System.out.println(n >= 1 && n <= 100);

        // 문자 ch1이 영어 대문자인지 검사
        char ch1 = 'G';
        String ch1IsUcase = (ch1 >= 'A' && ch1 <= 'Z') ? "문자 ch1은 영어 대문자입니다." : "문자 ch1은 영어 대문자가 아닙니다.";
        System.out.println(ch1IsUcase);
//        char ch1 = 'G';
//        System.out.println(ch1 >= 'A' && ch1 <= 'Z');

        // 문자 ch2가 영어 소문자인지 검사
        char ch2 = 'g';
        String ch2IsLcase = (ch2 >= 'a' && ch2 <= 'z') ? "문자 ch2는 영어 소문자입니다." : "문자 ch2는 영어 소문자가 아닙니다.";
        System.out.println(ch2IsLcase);
//        char ch2 = 'g';
//        System.out.println(ch2 >= 'a' && ch2 <= 'z');

        // 문자 yn이 대소문자 관계없이 y인지 검사
        char yn = 'Y';
        String ynIsY = (yn == 'y' || yn == 'Y') ? "문자 yn은 대소문자 관계없이 'y'입니다." : "문자 yn은 'y'가 아닙니다.";
        System.out.println(ynIsY);
//        char yn = 'Y';
//        System.out.println(yn == 'y' || yn == 'Y');

        // 문자 k가 영문자인지 검사
        char k = 'z';
        String kIsEng = ((k >= 'A' && k <= 'Z') || (k >= 'a' && k <= 'z')) ? "문자 k는 영문자입니다." : "문자 k는 영문자가 아닙니다.";
        System.out.println(kIsEng);
//        char k = 'z';
//        System.out.println((k >= 'A' && k <= 'Z') || (k >= 'a' && k <= 'z'));


    }
}