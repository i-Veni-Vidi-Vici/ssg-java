package com.ssg.test.operator.logical;

public class Ex01 {
    public static void main(String[] args) {
        int hKoreanScore = 80;
        int hEnglishScore = 70;
        int hMathScore = 90;
        int hSumScore = hKoreanScore + hEnglishScore + hMathScore;
        double hAverage = hSumScore / 3.0;

        int sKoreanScore = 95;
        int sEnglishScore = 80;
        int sMathScore = 100;
        int sSumScore = sKoreanScore + sEnglishScore + sMathScore;
        double sAverage = sSumScore / 3.0;

        System.out.println(
                "홍길동의 총점은 = " + hSumScore +
                        " 평균은 = " + hAverage +
                        " 합격여부는 " + (hKoreanScore >= 40 && hEnglishScore >= 40 && hMathScore >=40 && hAverage >= 60 ? "합격입니다." : "불합격입니다."));
        System.out.println(
                "신사임당의 총점은 = " + sSumScore +
                        " 평균은 = " + sAverage +
                        " 합격여부는 " +(sKoreanScore >= 40 && sEnglishScore >= 40 && sMathScore >= 40 && sAverage >=60 ? "합격입니다." : "불합격입니다.")
        );
    }
}
