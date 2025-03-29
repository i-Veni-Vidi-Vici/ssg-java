package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        int korean, english, math; // 국어, 영어, 수학 변수 선언
        korean = 80; // 홍길동의 국어 점수 대입
        english = 70; // 홍길동의 영어 점수 대입
        math = 90; // 홍길동의 수학 점수 대입

        int sum1 = korean + english + math; // 홍길동의 총점(정수)
        double avg1 = sum1 / 3; // 홍길동의 평균(실수)
        System.out.println(sum1);
        System.out.println(avg1);
        System.out.println("홍길동의 점수는 " +
                (((korean >= 40 && english >= 40 && math >= 40) && avg1 >= 60)
                        ? "합격입니다." : "불합격입니다."));

        korean = 95; // 심사임당의 국어 점수 대입
        english = 80; // 심사임당의 영어 점수 대입
        math = 100; // 심사임당의 수학 점수 대입

        int sum2 = korean + english + math; // 심사임당 총점(정수)
        double avg2 = sum2 / 3; // 심사임당 평균(실수)
        System.out.println(sum2);
        System.out.println(avg2);
        System.out.println("심사임당의 점수는 " +
                (((korean >= 40 && english >= 40 && math >= 40) && avg2 >= 60)
                        ? "합격입니다." : "불합격입니다."));

    }
}
