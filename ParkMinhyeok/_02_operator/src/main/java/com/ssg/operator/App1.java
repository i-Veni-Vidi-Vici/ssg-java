package com.ssg.operator;

public class App1 {
    public static void main(String[] args) {
        int hongKoreaScore = 80;
        int hongEnglishScore = 70;
        int hongMathScore = 90;

        int shinKoreaScore = 95;
        int shinEnglishScore = 80;
        int shinMathScore = 100;

        int hongTotalScore = (hongKoreaScore + hongEnglishScore + hongMathScore);
        int shinTotalScore = (shinKoreaScore + shinEnglishScore + shinMathScore);

        float hongAvg = hongTotalScore / 3;
        float shinAvg = shinTotalScore / 3;

        System.out.println(hongKoreaScore >= 40 && hongEnglishScore >= 40 && hongMathScore >= 40 && hongTotalScore >= 60? "합격" : "불합격");
        System.out.println(shinKoreaScore >= 40 && shinEnglishScore >= 40 && shinMathScore >=40 && shinTotalScore >= 60 ? "합격" : "불합격");

    }
}
