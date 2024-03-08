package com.sh.operator.operator;

public class App1 {

    public static void main(String[] args) {

        // 첫번째 학생 : 홍길동, 국어 : 80, 영어 : 70, 수학 : 90
        String name1 = "홍길동";
        int name1Korean = 80;
        int name1English = 70;
        int name1Math = 90;
        int name1Total = name1Korean + name1English + name1Math;
        double name1Avg = name1Total / 3;

        // 세 과목의 점수가 각각 40점 이상이면서 , 평균이 60점이상이면 True 반환, 둘 중 하나라도 만족하지 못하면 False 반환
        boolean name1IsSuccessed = (name1Korean >= 40 && name1English >=40 && name1Math >= 40) && (name1Avg >= 60);
        System.out.print("이름 : " + name1 + " 총점 : " + name1Total + " 평균 : " + name1Avg );
        System.out.println(name1IsSuccessed ? " [합격]" : " [불합격]");

        //두번째 학생 : 신사임당, 국어 : 95, 영어 : 80, 수학 : 100
        String name2 = "신사임당";
        int name2Korean = 95;
        int name2English = 80;
        int name2Math = 100;
        int name2Total = name2Korean + name2English + name2Math;
        double name2Avg = name2Total / 3;

        boolean name2IsSuccessed = (name2Korean >= 40 && name2English >=40 && name2Math >= 40) && (name2Avg >= 60);
        System.out.print("이름 : " + name2 + " 총점 : " + name2Total + " 평균 : " + name2Avg );
        System.out.println(name2IsSuccessed ? " [합격]" : " [불합격]");
    }


}
