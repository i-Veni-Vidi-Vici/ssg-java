package com.ssg.test.operator;

public class App2 {

    public static void main(String[] args) {
        String hongPhoneNumber = "01012341234";
        char hongGender = 'M';
        String hongAddress = "서울시 서초구 방배동";

        String shinPhoneNumber = "01044443333";
        char shinGender = 'F';
        String shinAddress = "경기도 남양주시 별내면";

        System.out.println("이름\t\t\t전화번호\t\t\t성별\t\t\t주소\n---------------------------------------------------------");
        System.out.println("홍길동\t\t" + hongPhoneNumber + "\t\t" + (hongGender == 'M' ? '남' : '여') + "\t\t\t" + hongAddress);
        System.out.println("신사임당\t\t" + shinPhoneNumber + "\t\t" + (shinGender == 'M' ? '남' : '여') + "\t\t\t" + shinAddress);
    }
}
