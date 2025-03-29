package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {
        String name, phoneNum, gender, address;

        System.out.println("이름    전화번호        성별    주소");
        System.out.println("---------------------------------------------");

        name = "홍길동";
        phoneNum = "01012341234";
        gender = "M";
        address = "서울시 서초구 방배동";
        System.out.println(name + "   " + phoneNum + "   " + (gender == "M" ? "남" : "여") + "      " + address);

        name = "신사임당";
        phoneNum = "01044443333";
        gender = "F";
        address = "경기도 남양주시 별내면";
        System.out.println(name + "  " + phoneNum + "  " + (gender == "M" ? "남" : "여") + "      " + address);
    }
}
