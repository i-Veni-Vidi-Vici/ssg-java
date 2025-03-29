package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        int n = 3;         // 과목 수
        int korOfHong = 80;     // 홍길동 국어
        int engOfHong = 70;     // 홍길동 영어
        int mathOfHong = 90;    // 홍길동 수학
        int korOfShin = 95;     // 신사임당 국어
        int engOfShin = 80;     // 신사임당 영어
        int mathOfShin = 100;   // 신사임당 수학
        int sumOfHong = korOfHong + engOfHong + mathOfHong; // 홍길동 총점
        int sumOfShin = korOfShin + engOfShin + mathOfShin; // 신사임당 총점
        double avgOfHong = sumOfHong / (double)n; // 홍길동 평균
        double avgOfShin = sumOfShin / (double)n; // 신사임당 평균

        System.out.println("홍길동의 총점: " + sumOfHong + ", 평균: " + avgOfHong + ", 합격여부: " + (korOfHong>=40 && engOfHong>=40 && mathOfHong>=40 && avgOfHong>=60 ? "합격" : "불합격"));
        System.out.println("신사임당의 총점: " + sumOfShin + ", 평균: " + avgOfShin + ", 합격여부: " + (korOfShin>=40 && engOfShin>=40 && mathOfShin>=40 && avgOfShin>=60 ? "합격" : "불합격"));
    }
}