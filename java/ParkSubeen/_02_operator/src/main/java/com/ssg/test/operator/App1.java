package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        int korean, english, math; // 국어, 영어, 수학 변수 선언
        korean = 80;
        english = 70;
        math = 90;
        int total1 = korean + english + math; // 홍길동의 총점 선언
        double avg1 = total1 / 3; // 홍길동의 평균 선언
        System.out.println("홍길동님의 총점 : " + total1 + ", 평균 : " + avg1);
        System.out.println("홍길동님은 " + (((korean >= 40 && english >= 40 && math >= 40) && avg1 >= 60) ? "합격입니다." : "불합격입니다."));

        korean = 95;
        english = 80;
        math = 100;
        int total2 = korean + english + math; // 신사임당의 총점 선언
        double avg2 = total2 / 3; // 신사임당의 평균 선언
        System.out.println("신사임당님의 총점 : " + total2 + ", 평균 : " + avg2);
        System.out.println("신사임당님은 " + (((korean >= 40 && english >= 40 && math >= 40) && avg2 >= 60) ? "합격입니다." : "불합격입니다."));
    }
}
