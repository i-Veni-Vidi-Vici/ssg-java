package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {
        String Name1 = "홍길동";
        int phone1 = 01012341234;
        char gen1 = 'M';
        String addr1 = "서울시 서초구 방배동";

        String Name2 = "신사임당";
        int phone2 = 01044443333;
        char gen2 = 'F';
        String addr2 = "경기도 남양주시 별내면";

        System.out.println("이 름  전화번호  성별  주소");
        System.out.println(Name1+" " + phone1+" " +" "+ (gen1=='M'?"남":"여")+ " "+ addr1);
        System.out.println(Name2+" " + phone2+" " +" "+ (gen2=='M'?"남":"여")+ " "+ addr2);
    }
}
