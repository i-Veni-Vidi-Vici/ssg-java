package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        String student1Name = "홍길동";
        int student1Language = 80;
        int student1English = 70;
        int student1Math = 90;
        int student1Total;
        double student1Avg;
        student1Total = student1Language + student1English + student1Math;
        student1Avg = student1Total / 3.0;
        System.out.println("총점: " + student1Total + " / 평균: " + student1Avg + " / 합격여부: " +
                ((student1Language >= 40 && student1English >= 40 && student1Math >= 40 && student1Avg >= 60) ?
                    "합격" :
                        "불합격"));

        String student2Name = "신사임당";
        int student2Language = 95;
        int student2English = 80;
        int student2Math = 100;
        int student2Total;
        double student2Avg;
        student2Total = student2Language + student2English + student2Math;
        student2Avg = student2Total / 3.0;
        System.out.println("총점: " + student2Total + " / 평균: " + student2Avg + " / 합격여부: " +
                ((student2Language >= 40 && student2English >= 40 && student2Math >= 40 && student2Avg >= 60) ?
                    "합격" :
                        "불합격"));
    }
}
