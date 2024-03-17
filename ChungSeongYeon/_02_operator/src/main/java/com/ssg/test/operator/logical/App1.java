package com.ssg.test.operator.logical;

public class App1 {
    public static void main(String[] args){

        // 홍길동의 점수 (국어: 80, 영어: 70, 수학: 90)
        int hongKor = 80;
        int hongEng = 70;
        int hongMath = 90;

        // 신사임당의 점수 (국어: 95, 영어: 80, 수학: 100)
        int sinKor = 95;
        int sinEng = 80;
        int sinMath = 100;

        // 홍길동의 총점과 평균 계산
        int hongTotal = hongKor + hongEng + hongMath;
        double hongAvg = hongTotal / 3.0;

        // 신사임당의 총점과 평균 계산
        int sinTotal = sinKor + sinEng + sinMath;
        double sinAvg = sinTotal / 3.0;

        // 합격 여부 확인 및 출력
        String hongResult = (hongKor >= 40 && hongEng >= 40 && hongMath >= 40 && hongAvg >= 60) ? "합격" : "불합격";
        String sinResult = (sinKor >= 40 && sinEng >= 40 && sinMath >= 40 && sinAvg >= 60) ? "합격" : "불합격";

        // 결과 출력
        System.out.println("홍길동 - 총점: " + hongTotal + ", 평균: " + hongAvg + ", 결과: " + hongResult);
        System.out.println("신사임당 - 총점: " + sinTotal + ", 평균: " + sinAvg + ", 결과: " + sinResult);  // Math.round(hongAvg || sinAvg) -> 소수점 없애기

//        // 강사님's 해설
//        String name;
//        int kor, eng, math, total; // 같은 타입 n개 변수를 선언할 때
//        double avg;
//
//        // data1
//        name = "홍길동";
//        kor = 80;
//        eng = 70;
//        math = 90;
//        total = kor + eng + math;
//        avg = total / 3.0; // 3으로 나누면 결과값이 int라서 소수점이하를 구할수 없다.
//
//        boolean eachSubjectPassed = kor >= 40 && eng >= 40 && math >= 40;
//        boolean avgPassed = avg >= 60;
//        System.out.println(name + " : 총점 = " + total + ", 평균 = " + avg + ", 합격여부 = " + (eachSubjectPassed && avgPassed ? "합격" : "불합격"));
//
//        // data2
//        name = "신사임당";
//        kor = 95;
//        eng = 80;
//        math = 100;
//        total = kor + eng + math;
//        avg = total / 3.0; // 3으로 나누면 결과값이 int라서 소수점이하를 구할수 없다.
//        System.out.println(name + " : 총점 = " + total + ", 평균 = " + avg + ", 합격여부 = " + (eachSubjectPassed && avgPassed ? "합격" : "불합격"));

    }
}
