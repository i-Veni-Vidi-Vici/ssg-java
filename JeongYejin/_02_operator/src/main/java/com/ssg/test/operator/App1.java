package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        //홍길동
        int korean = 80;
        int english = 70;
        int math = 90;
        int sum = korean + english + math;
        double avg = sum/3.0;
        System.out.println("홍길동 총점: " + sum + ", 평균: " + avg + ", " + (korean >= 40 && english >= 40 && math >= 40 && avg >= 60 ? "합격" : "불합격"));
        //신사임당
        korean = 95;
        english = 80;
        math = 100;
        sum = korean + english + math;
        avg = sum/3.0;
        System.out.println("신사임당 총점: " + sum + ", 평균: " + avg + ", " + (korean >= 40 && english >= 40 && math >= 40 && avg >= 60 ? "합격" : "불합격"));
    }
}
