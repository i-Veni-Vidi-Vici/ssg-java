package com.ssg.test.operator;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class App2 {
    public static void main(String[] args){
        String a;
        String name1 = "홍길동";
        String number1 = "01012341234";
        char gender1 = 'M';
        String address1 = "서울시 서초구 방배동";

        String name2 = "신사임당";
        String number2 = "01044443333";
        char gender2 = 'F';
        String address2 = "경기도 남양주시 별내면";

        System.out.println("이 름    전화번호     성별    주소");
        System.out.println("----------------------------------------------");
        System.out.println(name1+"  " + number1+"  " + (gender1=='M'?" 남   ":" 여   ") + address1);
        System.out.println(name2+" " + number2 +"  "+ (gender1=='F'?" 남   ":" 여   ") + address2);
    }
}
