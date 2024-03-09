package com.ssg.test.operator;

public class App1 {

    public static void main(String[] args) {
        int hongKoreanScore = 80;
        int hongEnglishScore = 70;
        int hongMathScore = 90;
        int hongTotalScore = hongKoreanScore + hongEnglishScore + hongMathScore;
        double hongAverageScore = hongTotalScore / 3.0;

        int shinKoreanScore = 95;
        int shinEnglishScore = 80;
        int shimMathScore = 100;
        int shinTotalScore = shinKoreanScore + shinEnglishScore + shimMathScore;
        double shinAverageScore = shinTotalScore / 3.0;

        System.out.println("-홍길동-\n총점 : " + hongTotalScore
                + "\n평균 : " + hongAverageScore
                + "\n합격 여부 : " + (hongKoreanScore >= 40
                                && hongEnglishScore >= 40
                                && hongMathScore >= 40
                                && hongAverageScore >= 60 ? "합격" : "불합격"));

        System.out.println("\n-신사임당-\n총점 : " + shinTotalScore
                + "\n평균 : " + shinAverageScore
                + "\n합격 여부 : " + (shinKoreanScore >= 40
                                && shinEnglishScore >= 40
                                && shimMathScore >= 40
                                && shinAverageScore >= 60 ? "합격" : "불합격"));
    }
}
