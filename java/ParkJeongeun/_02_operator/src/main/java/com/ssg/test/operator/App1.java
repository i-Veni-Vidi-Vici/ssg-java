package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        int hgdKr = 80;
        int hgdEng = 70;
        int hgdMath = 90;
        int ssidKr = 95;
        int ssidEng = 80;
        int ssidMath = 100;

        int hgdSum = hgdKr + hgdEng + hgdMath;
        int ssidSum = ssidKr + ssidEng + ssidMath;

        double hgdAvg = hgdSum / 3.0; // 3으로 나누면 결과값이 int라서 소수점이하를 구할수 없다.
        double ssidAvg = ssidSum / 3.0; // 3으로 나누면 결과값이 int라서 소수점이하를 구할수 없다.

        // 홍길동
        System.out.println("홍길동의 총점 = " + hgdSum);
        System.out.println("홍길동의 평균 = " + hgdAvg);
        System.out.println("홍길동의 합격여부 = " + ((hgdKr >= 40 && hgdEng >= 40 && hgdMath >= 40) && (hgdAvg >= 60) ? "합격" : "불합격")); // boolean문 전체를 괄호로 묶기

        // 신사임당
        System.out.println("신사임당의 총점 = " + ssidSum);
        System.out.println("신사임당의 평균 = " + ssidAvg);
        System.out.println("신사임당의 합격여부 = " + ((ssidKr >= 40 && ssidEng >= 40 && ssidMath >= 40) && (ssidAvg >= 60) ? "합격" : "불합격")); // boolean문 전체를 괄호로 묶기

    }
}
