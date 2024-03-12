package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        String name;
        int kor, eng, math, total;
        double avg;

        // data1
        name = "홍길동";
        kor = 80;
        eng = 70;
        math = 90;
        total = kor + eng + math;
        avg = total / 3.0; // 3으로 나누면 결과값이 int라서 소수점이하를 구할수 없다.

        boolean eachSubjectPassed = kor >= 40 && eng >= 40 && math >= 40;
        boolean avgPassed = avg > 60;
        System.out.println(name + " : 총점 = " + total + ", 평균 = " + avg + ", 합격여부 = " + (eachSubjectPassed && avgPassed ? "합격" : "불합격"));

        // data2
        name = "신사임당";
        kor = 95;
        eng = 80;
        math = 100;
        total = kor + eng + math;
        avg = total / 3.0; // 3으로 나누면 결과값이 int라서 소수점이하를 구할수 없다.
        System.out.println(name + " : 총점 = " + total + ", 평균 = " + avg + ", 합격여부 = " + (eachSubjectPassed && avgPassed ? "합격" : "불합격"));

    }
}
