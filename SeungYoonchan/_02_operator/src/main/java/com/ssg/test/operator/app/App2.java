package com.ssg.test.operator.app;

public class App2 {
    public static void main(String[] args){
        String name1, phoneNumber1, gender1, address1;
        String name2, phoneNumber2, gender2, address2;
        String temp1, temp2;

        name1 = "홍길동";
        phoneNumber1 = "01012341234";
        gender1 = "M";
        address1 = "서울시 서초구 방배동";

        name2 = "신사임당";
        phoneNumber2 = "01044443333";
        gender2 = "F";
        address2 = "경기도 남양주시 별내면";

        // 삼항연산자 사용
        // 성별이 M 또는 n으로 입력 받았을때 남자로 판단하여 '남'을 반환 아니라면 '여'로 반환
        temp1 = (gender1 == "M" || gender1 == "n") ? "남" : "여";
        temp2 = (gender2 == "M" || gender2 == "n") ? "남" : "여";

        System.out.println("\t이름\t\t\t전화번호\t\t\t성별\t\t\t주소\t");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\t" + name1 + "\t\t" + phoneNumber1 + "\t\t" + temp1 + "\t\t" + address1 + "\t");
        System.out.println("\t" + name2 + "\t\t" + phoneNumber2 + "\t\t" + temp2 + "\t\t" + address2 + "\t");
    }
}
