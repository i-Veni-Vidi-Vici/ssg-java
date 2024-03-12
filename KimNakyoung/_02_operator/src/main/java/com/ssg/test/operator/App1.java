package com.ssg.test.operator;
/*
과제 2 - 문제 1
 */
public class App1 {
    public static void main (String[] args){

//        1. 국어(정수), 영어(정수), 수학(정수), 총점(정수), 평균(실수) 변수 선언후
        int hongKoreaScore = 80; // 홍길동 국어
        int hongEnglishScore = 70; // 홍길동 영어
        int hongMathScore = 90; // 홍길동 수학
        int sinKoreaScore = 95; // 신사임당 국어
        int sinEnglishScore = 90; // 신사임당 영어
        int sinMathScore = 100; // 신사임당 수학
        int hongTotalScore = (hongKoreaScore + hongEnglishScore + hongMathScore); // 홍길동 총점
        int sinTotalScore = (sinKoreaScore + sinEnglishScore + sinMathScore); // 신사임당 총점
        double hongAvg = hongTotalScore / 3 ; // 홍길동 평균
        double sinAvg = sinTotalScore / 3 ; // 신사임당 평균

//        2. 총점, 평균, 합격여부 출력.
        System.out.println("홍길동 총점 : " + hongTotalScore);
        System.out.println("신사임당 총점 : " + sinTotalScore);
        System.out.println("홍길동 평균 : " + hongAvg);
        System.out.println("신사임당 총점 : " + sinAvg);

//        3. 합격의 조건 : 세 과목의 점수가 각각 40점이상이면서, 평균이 60점 이상이면 합격, 아니면 "불합격" 출력
        // 합격여부
        System.out.println(hongKoreaScore >= 40 && hongEnglishScore >= 40 && hongMathScore >= 40 && hongAvg >= 60 ? "합격" : "불합격" ); // 홍길동 합격여부
        System.out.println(sinKoreaScore >= 40 && sinEnglishScore >= 40 && sinMathScore >= 40 && sinAvg >= 60 ? "합격" : "불합격" ); // 신사임당 합격여부

    }
}
