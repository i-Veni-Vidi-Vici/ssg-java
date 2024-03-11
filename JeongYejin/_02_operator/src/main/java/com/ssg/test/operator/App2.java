package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {
        //홍길동
        String name = "홍길동";
        String number = "01012341234";
        char sex = 'M';
        String address = "서울시 서초구 방배동";

        System.out.println("이 름  전화번호    성별  주소");
        System.out.println("--------------------------------------");
        System.out.println(name + " " + number + " " + (sex == 'M' ? "남" : "여") + " " + address);

        //신사임당
        name = "신사임당";
        number = "01044443333";
        sex = 'F';
        address = "경기도 남양주시 별내면";

        System.out.println(name + " " + number + " " + (sex == 'M' ? "남" : "여") + " " + address);
    }
}
