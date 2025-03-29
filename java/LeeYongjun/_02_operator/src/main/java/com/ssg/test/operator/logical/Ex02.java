package com.ssg.test.operator.logical;

public class Ex02 {
    public static void main(String[] args) {
        String hPhoneNumber = "01012341234";
        char hGender = 'M';
        String hAddress = "서울시 서초구 방배동";

        String sPhoneNumber = "01044443333";
        char sGender = 'F';
        String sAddress = "경기도 남양주시 별내면";

        System.out.println("이름\t\t전화번호\t\t성별\t\t주소\n");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("홍길동\t" + hPhoneNumber + "\t  " + hGender + "\t\t" + hAddress);
        System.out.println("신사임당\t" + sPhoneNumber + "\t  " + sGender + "\t\t" + sAddress);

    }
}
