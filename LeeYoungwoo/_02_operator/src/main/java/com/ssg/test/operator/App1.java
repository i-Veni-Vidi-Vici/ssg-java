package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        // 문제1
        // 1. 국어(정수), 영어(정수), 수학(정수), 총점(정수), 평균(실수) 변수 선언
        int hongKorScore = 80;
        int hongEngScore = 70;
        int hongMathScore = 90;
        int sinKorScore = 95;
        int sinEngScore = 80;
        int sinMathScore = 100;
        int hongSumScore = hongKorScore + hongEngScore +hongMathScore;
        int sinSumScore = sinKorScore + sinEngScore + sinMathScore;
        float hongAverage = (hongKorScore + hongEngScore +hongMathScore)/3;
        float sinAverage = (sinKorScore + sinEngScore + sinMathScore)/3;

        // 2. 총점, 평균, 합격여부 출력.
        System.out.println("hong총점 = " + hongSumScore);
        System.out.println("hong평균 = " + hongAverage);
        System.out.println("hong합격여부 = " + ((hongKorScore >= 40 && hongEngScore >= 40 && hongMathScore >= 40 &&
                hongAverage >= 60) ? "합격" : "불합격"));

        System.out.println("sin총점 = " + sinSumScore);
        System.out.println("sin평균 = " + sinAverage);
        System.out.println("sin합격여부 = " + ((sinKorScore >= 40 && sinEngScore >= 40 && sinMathScore >= 40 &&
                sinAverage >= 60) ? "합격" : "불합격"));
    }
}
