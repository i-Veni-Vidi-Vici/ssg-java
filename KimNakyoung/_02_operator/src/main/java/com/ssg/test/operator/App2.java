package com.ssg.test.operator;
/*
과제 2 - 문제 2
 */
public class App2 {
    public static void main (String[] args){
        String hongUserName = "홍길동";
        String sinUserName = "신사임당";
        String hongNumber = "01012341234";
        String sinNumber = "01044443333";
        String hongGender = "M";
        String sinGender = "F";
        String hongAddress = "서울시 서초구 방배동";
        String sinAddress = "경기도 남양주시 별내면";

        System.out.println("이 름 전화번호     성별   주소");
        System.out.println("-------------------------------");
        System.out.println(hongUserName +" "+hongNumber + ((hongGender == "M") ? " 남 " : " 여 " ) + hongAddress );
        System.out.println(sinUserName +" "+sinNumber + ((sinGender == "M") ? " 남 " : " 여 " ) + sinAddress );


    }
}
