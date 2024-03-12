package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {
        // 문제2
        String name, phone, address;
        char gender;

        // 헤더
        System.out.println("이름  전화번호    성별      주소");
        System.out.println("-----------------------------------------------");

        // data1
        name = "홍길동";
        phone = "01012341234"; // 전화번호는 숫자지만, 시작하는 0처리를 위해 문자열로 처리해야 한다. 또한 연산할 필요도 없다.
        gender = 'M';
        address = "서울시 서초구 방배동";
        // 문자열 안에서 탭문자(\t), 개행문자(\n)등을 처리할 수 있다.
        System.out.println(name + "\t" + phone + "\t" + (gender == 'M' ? "남" : "여") + "\t" + address); // \t는 탭문자를 의미한다.

        // data2
        name = "신사임당";
        phone = "0104444333";
        gender = 'F';
        address = "경기도 남양주시 별내면";
        System.out.println(name + "\t" + phone + "\t" + (gender == 'M' ? "남" : "여") + "\t" + address);
    }
}
