package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        int hongKorean = 80;
        int hongEnglish = 70;
        int hongMath = 90;
        int hongSum = 0;
        double hongAvg = 0;

        int shinKorean = 95;
        int shinEnglish = 80;
        int shinMath = 100;
        int shinSum = 0;
        int shinAvg = 0;

        hongSum = hongKorean + hongEnglish + hongMath;
        hongAvg = hongSum / 3;

        shinSum = shinKorean + shinEnglish + shinMath;
        shinAvg = shinSum / 3;


        System.out.println("홍길동 총점: "+ hongSum + "\n홍길동 평균" + hongAvg );
        System.out.println(hongKorean>=40 && hongEnglish >=40 && hongMath >=40 && hongAvg>60 ? "합격" : "불합격");

        System.out.println("신사임당 총점: "+ shinSum + "\n신사임당 평균" + shinAvg );
        System.out.println(shinKorean>=40 && shinEnglish >=40 && shinMath >=40 && shinAvg>60 ? "합격" : "불합격");

    }
}
