package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args){
        String name = "홍길동";
        String phoneNum = "01012341234";
        char gender = 'M';
        String address = "서울시 서초구 방배동";

        System.out.println("이 름  전화번호   성별  주소");
        System.out.println("----------------------------------------");
        System.out.println(name + "\t" + phoneNum + "\t" + (gender =='M'?"남":"여") + "\t" + address);

        name = "신사임당";
        phoneNum = "01044443333";
        sex = 'F';
        address = "경기도 남양주시 별내면";

        System.out.println(name + "\t" + phoneNum + "\t" + (gender =='M'?"남":"여") + "\t" + address);
    }
}
