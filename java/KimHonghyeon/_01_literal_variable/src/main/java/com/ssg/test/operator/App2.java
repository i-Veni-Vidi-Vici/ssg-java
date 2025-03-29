package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {
        String hong_PhoneNumber = "01012341234";
        char hong_gender = 'M';
        String hong_Address = "서울시 서초구 방배동";

        String shin_PhoneNumber = "01044443333";
        char shin_gender = 'F';
        String shin_Address = "경기도 남양주시 별내면";

        System.out.println("이름    전화번호    성별    주소");
        System.out.println("--------------------------------");
        System.out.println("홍길동 " + hong_PhoneNumber + " " +(hong_gender=='M'? '남':'여') + " " + hong_Address);
        System.out.println("신사임당 " + shin_PhoneNumber + " " +(shin_gender=='M'? '남':'여') + " " + shin_Address);

    }
}
