package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        // 홍길동
        String name = "홍길동"
        int koreanScore = 80;
        int englishScore = 70;
        int mathScore = 90;
        int total = koreanScore + englishScore + mathScore;
        double average = total / 3.0; // 3으로 나누면 결과값이 int라서 소수점 이하를 구할 수 없다.

        System.out.println(koreanScore >= 40 && englishScore >= 40 && mathScore >= 40 && average >= 60 ? "합격" : "불합격");

        // 신사임당
        koreanScore = 95;
        englishScore = 80;
        mathScore = 100;
        total = koreanScore + englishScore + mathScore;
        average = total / 3.0; // 3으로 나누면 결과값이 int라서 소수점 이하를 구할 수 없다.

        System.out.println(koreanScore >= 40 && englishScore >= 40 && mathScore >= 40 && average >= 60 ? "신사임당 합격" : "신사임당 불합격");
    }
}
