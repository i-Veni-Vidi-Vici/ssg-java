package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {

        // 변수 선언
        String name;
        String result;
        int numberOfSubjects = 3;

        int korean;
        int english;
        int math;
        int sum;
        double average;

        // 홍길동
        // 대입
        name = "홍길동";
        korean = 80;
        english = 70;
        math = 90;

        // 연산
        sum = korean + english + math;
        average = (double) sum / numberOfSubjects;
        result = (korean >= 40) && (english >= 40) && (math >= 40) && (average >= 60) ? "합격" : "불합격";

        // 출력
        System.out.println(name + "님의 총점은 " + sum + ", 평균은 " + average + ", 합격 여부는 " + result + "입니다.");

        // 신사임당
        // 대입
        name = "신사임당";
        korean = 95;
        english = 80;
        math = 100;

        // 연산
        sum = korean + english + math;
        average = (double) sum / numberOfSubjects;
        result = (korean >= 40) && (english >= 40) && (math >= 40) && (average >= 60) ? "합격" : "불합격";

        // 출력
        System.out.println(name + "님의 총점은 " + sum + ", 평균은 " + average + ", 합격 여부는 " + result + "입니다.");
    }
}
