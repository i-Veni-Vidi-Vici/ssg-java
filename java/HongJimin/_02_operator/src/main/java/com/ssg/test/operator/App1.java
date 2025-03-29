package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
         int koreanScore;
         int englishScore;
         int mathScore;
         int totalScore;
         double average;

         koreanScore = 80;
         englishScore = 70;
         mathScore = 90;
         totalScore = koreanScore + englishScore + mathScore;
         average = totalScore / 3;

         System.out.println("홍길동의 총점은 " + totalScore + "입니다.");
         System.out.println("홍길동의 평균 점수는 " + average + "입니다" );
         if (koreanScore < 40) {
              System.out.println("홍길동은 불합격입니다ㅜㅡㅜ");
         } else if (englishScore >= 40 && mathScore >=40 && average >= 60) {
              System.out.println("홍길동은 합격입니다!");
         }

         koreanScore = 95;
         englishScore = 80;
         mathScore = 100;
         totalScore = koreanScore + englishScore + mathScore;
         average = totalScore / 3;

         System.out.println("신사임당의 총점은 " + totalScore + "입니다.");
         System.out.println("신사임당의 평균 점수는 " + average + "입니다" );
         if (koreanScore < 40) {
              System.out.println("신사임당은 불합격입니다ㅜㅡㅜ");
         } else if (englishScore >= 40 && mathScore >=40 && average >= 60) {
              System.out.println("신사임당은 합격입니다!");
         }
    }
}
