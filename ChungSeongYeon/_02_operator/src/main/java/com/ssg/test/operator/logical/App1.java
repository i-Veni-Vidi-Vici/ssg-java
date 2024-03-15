package com.ssg.test.operator.logical;

public class App1 {
    public static void main(String[] args){

                // 홍길동의 점수
                int hongKor = 80;
                int hongEng = 70;
                int hongMath = 90;

                // 신사임당의 점수
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

    }
}
