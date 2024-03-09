package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {

        // 변수 선언 및 초기화
        String name = "";
        String result = "";
        int numberOfSubjects = 3;
        int koreanScore = 0;
        int englishScore = 0;
        int mathScore = 0;
        int totalScore = 0;
        double average = 0;

        // 홍길동, 국어 80 영어 70 수학 90
        // 값 대입
        name = "홍길동";
        koreanScore = 80;
        englishScore = 70;
        mathScore = 90;

        // 연산
        totalScore = koreanScore + englishScore + mathScore;
        average = totalScore / numberOfSubjects;
        result = (koreanScore >= 40) && (englishScore >= 40) && (mathScore >= 40) && (average >= 60) ? "합격" : "불합격";

        // 출력
        System.out.println(name + "님의 총점은 " + totalScore + ", 평균은 " + average + ", 합격여부는 " + result + "입니다.");

        // 신사임당, 국어 95 영어 80 수학 100
        // 점수 대입
        name = "신사임당";
        koreanScore = 95;
        englishScore = 80;
        mathScore = 100;

        // 연산
        totalScore = koreanScore + englishScore + mathScore;
        average = (double) totalScore / numberOfSubjects;
        result = (koreanScore >= 40) && (englishScore >= 40) && (mathScore >= 40) && (average >= 60) ? "합격" : "불합격";

        // 출력
        System.out.println(name + "님의 총점은 " + totalScore + ", 평균은 " + average + ", 합격여부는 " + result + "입니다.");
    }
}
