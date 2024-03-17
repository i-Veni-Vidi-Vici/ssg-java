package com.ssg.test.operator.logical;

public class App2 {
    public static void main(String[] args) {

        // 홍길동의 정보 (전화번호 : 01012341234, 성별 : 남 , 주소 : 서울시 서초구 방배동)
        String hongName = "홍길동";
        String hongPhoneNum = "01012341234";
        char hongGender = 'M';
        String hongAddress = "서울시 서초구 방배동";

        // 신사임당의 정보 (전화번호 : 01044443333, 성별 : 여, 주소 : 경기도 남양주시 별내면)
        String sinName = "신사임당";
        String sinPhoneNum = "01044443333";
        char sinGender = 'F';
        String sinAddress = "경기도 남양주시 별내면";

        // 성별 출력 처리
        String hongGenderStr = (hongGender == 'M') ? "남" : "여";
        String sinGenderStr = (sinGender == 'M') ? "남" : "여";

        // 결과 출력
        System.out.println("이름   전화번호    성별       주소");
        System.out.println("--------------------------------------");
        System.out.println(hongName + " " + hongPhoneNum + " " + hongGenderStr + " " + hongAddress);
        System.out.println(sinName + " " + sinPhoneNum + " " + sinGenderStr + " " + sinAddress);

//        강사님's 해설
//        String name, phone, address;
//        char gender;
//
//        // 헤더
//        System.out.println("이름  전화번호    성별      주소");
//        System.out.println("-----------------------------------------------");
//
//        // data1
//        name = "홍길동";
//        phone = "01012341234"; // 전화번호는 숫자지만, 시작하는 0처리를 위해 문자열로 처리해야 한다. 또한 연산할 필요도 없다.
//        gender = 'M';
//        address = "서울시 서초구 방배동";
//        // 문자열 안에서 탭문자(\t), 개행문자(\n)등을 처리할 수 있다. - escaping문자
//        System.out.println(name + "\t" + phone + "\t" + (gender == 'M' ? "남" : "여") + "\t" + address); // \t는 탭문자를 의미한다.
//
//        // data2
//        name = "신사임당";
//        phone = "0104444333";
//        gender = 'F';
//        address = "경기도 남양주시 별내면";
//        System.out.println(name + "\t" + phone + "\t" + (gender == 'M' ? "남" : "여") + "\t" + address);

    }
}
