package com.sh.operator.operator;

public class App2 {
    public static void main(String[] args) {
        // 첫번째 학생 : 홍길동, 전화번호 : 01012341234, 성별 : 남 , 주소 : 서울시 서초구 방배동.
        String name1 = "홍길동";
        String name1Phone = "01012341234";
        char name1Gender = 'M';
        String name1Address = "서울시 서초구 방배동 ";


        // 두번째 학생 : 신사임당, 정화번호 : 01044443333, 성별 : 여, 주소 : 경기도 남양주시 별내면.
        String name2 = "신사임당";
        String name2Phone = "01044443333";
        char name2Gender = 'F';
        String name2Address = "경기도 남양주시 별내면 ";

        System.out.println("이름 " + "   전화번호" + "    성별 " + "  주소");
        System.out.println("-------------------------------------------");
        System.out.println(name1+" "+ name1Phone +" " +((name1Gender == 77) ? "남" : "여") +" "+ name1Address);
        System.out.println(name2+" "+ name2Phone +" " +((name2Gender == 70) ? "여" : "남") +" "+ name2Address);
    }
}
