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

        double hongAvg = hongTotalScore / 3.0;
        double shinAvg = shinTotalScore / 3.0;

        System.out.println(hongKoreaScore >= 40 && hongEnglishScore >= 40 && hongMathScore >= 40 && hongAvg >= 60? "합격" : "불합격");
        System.out.println(shinKoreaScore >= 40 && shinEnglishScore >= 40 && shinMathScore >=40 && shinAvg >= 60 ? "합격" : "불합격");

    }
}
