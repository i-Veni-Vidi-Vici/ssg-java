package com.ssg.test.operator.app;

public class App1 {
    public static void main(String[] args){
        int korean1 = 80, english1 = 70, math1 = 90, sum1 = 0; // 홍길동 국어, 영어, 수학, 총점
        int korean2 = 95, english2 = 80, math2 = 100, sum2 = 0; // 신사임당 국어, 영어, 수학, 총점
        double avg1 = 0, avg2 =0; // 평균 (실수)
        boolean result1, result2;

        sum1 = korean1 + english1 + math1;  // 홍길동 총점
        avg1 = sum1 / 3;                    // 홍길동 평균

        sum2 = korean2 + english2 + math2;  // 신사임당 총점
        avg2 = sum2 / 3;                    // 신사임당 평균

        // 삼항연산자 사용
        // 국어 또는 영어 중에 40점이 넘지 않는다면 false를 반환하고
        // 국어와 영어 점수가 모두 40점이 넘는다면 수학은 40점이 넘으며 평균도 60이 넘는지 확인한다.

        // 홍길동
        result1 = ((korean1 >= 40 && english1 >= 40) ? math1 >= 40 && avg1 >= 60 : false);
        System.out.println("국어 : " + korean1 + ", 영어 : " + english1 + ", 수학 : " + math1);
        System.out.println("총점 : " + sum1 + ", 평균 : " + avg1);
        System.out.println("홍길동 : " + (result1 == true ? "합격" : "불합격")); // result가 true라면 합격 출력 아니라면 불합격 출력
        System.out.println();
        // 신사임당
        result2 = ((korean2 >= 40 && english2 >= 40) ? math2 >= 40 && avg2 >= 60 : false);
        System.out.println("국어 : " + korean2 + ", 영어 : " + english2 + ", 수학 : " + math2);
        System.out.println("총점 : " + sum2 + ", 평균 : " + avg2);
        System.out.println("신사임당 : " + (result2 == true ? "합격" : "불합격")); // result가 true라면 합격 출력 아니라면 불합격 출력
    }

}
