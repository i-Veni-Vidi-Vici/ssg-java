package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {

        // 변수 선언 및 초기화
        String name = "";
        String phone = "";
        char gender = ' ';
        String address = "";
        
        // 홍길동, 전화번호 01012341234 성별 M 주소 서울시 서초구 방배동
        // 값 대입
        name = "홍길동";
        phone = "01012341234";
        gender = 'M';
        address = "서울시 서초구 방배동";

        // 출력
        System.out.println("이름  전화번호    성별  주소");
        System.out.println("-------------------------------");
        System.out.println(name + " " + phone + " " + (gender == 'M' ? "남" : "여") + " " + address);

        // 신사임당, 전화번호 01044443333 성별 F 주소 경기도 남양주시 별내면
        // 값 대입
        name = "신사임당";
        phone = "01044443333";
        gender = 'F';
        address = "경기도 남양주시 별내면";

        // 출력
        System.out.println(name + " " + phone + " " + (gender == 'M' ? "남" : "여") + " " + address);

    }
}
