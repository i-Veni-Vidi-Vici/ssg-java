package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {

        // 변수 선언
        String name;
        String phone;
        char gender;
        String address;
        
        // 홍길동
        // 대입
        name = "홍길동";
        phone = "01012341234";
        gender = 'M';
        address = "서울시 서초구 방배동";

        // 출력
        System.out.println("이름  전화번호    성별  주소");
        System.out.println("-------------------------------");
        System.out.println(name + " " + phone + " " + (gender == 'M' ? "남" : "여") + " " + address);

        // 신사임당
        // 대입
        name = "신사임당";
        phone = "01044443333";
        gender = 'F';
        address = "경기도 남양주시 별내면";

        // 출력
        System.out.println(name + " " + phone + " " + (gender == 'M' ? "남" : "여") + " " + address);

    }
}
