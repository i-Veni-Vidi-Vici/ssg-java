package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args){
        String hnum="01012341234";
        char hsex='M';
        String hadr="서울시 서초구 방배동";
        String snum="01044443333";
        char ssex='F';
        String sadr="경기도 남양주시 별내면";
        System.out.println("이름   전화번호      성별     주소  ");
        System.out.println("-------------------------------------------------");
        System.out.println("홍길동  "+hnum+((hsex==77)?" 남 ":" 여 ")+hadr);
        System.out.println("신사임당  "+snum+((ssex==77)?" 남 ":" 여 ")+sadr);



    }
}
