package com.ssg.test.operator;

public class App2 {
    public static void main(String[] args) {
        String hong = "홍길동";    // 홍길동 이름
        String shin = "신사임당";   // 신사임당 이름
        String phoneNumOfHong = "01012341234";  // 홍길동 전화번호
        String phoneNumOfShin = "01044443333";  // 신사임당 전화번호
        String genderOfHong = "M";  // 홍길동 성별
        String genderOfShin = "F";  // 신사임당 성별
        String addressOfHong = "서울시 서초구 방배동";   // 홍길동 주소
        String addressOfShin = "경기도 남양주시 별내면";  // 신사임당 주소

        System.out.println("이 름  전화번호\t성별  주소");
        System.out.println("------------------------------------");
        System.out.println(hong + " " + phoneNumOfHong + " " + (genderOfHong=="M" ? "남" : "여") + "\t " + addressOfHong);
        System.out.println(shin + " " + phoneNumOfShin + " " + (genderOfShin=="M" ? "남" : "여") + "\t" + addressOfShin);
    }
}
