package com.sh.math;

/**
 * API
 * -application programing Interface
 * -운영체제/프로그래밍언어들이 제공하는 기능을 제어할 수 있도록 제공하는 인터페이스(규격)
 * -미리 만들어진 기능들을 가져다 쓰는 방법
 * API 문서로 정리를 잘해두었으니 수시로 참고해서 적용할 것
 *
 *
 * Math API
 * 수학 관련 자주 상용하는 상수 혹은 기능들을 작성해둔 클래스
 * 모든 메소드는 statuc으로 구성됨
 * 절대값, 올림 ,반올림 ,내림,난수생성등
 * -
 */

public class App {
    public static void main(String[] args) {
        // 절대값
        System.out.println(Math.abs(-7));
        System.out.println((Math.abs(+7)));
        System.out.println(Math.abs(-9.9));//double

        // 최대/최소값
        System.out.println(Math.max(10, 20));
        System.out.println(Math.max(20, 10));
        System.out.println(Math.min(10, 20));
        System.out.println(Math.min(10, 20));

        //난수 생성 : 0.0 이상~ 1.0 미만의 난수 (double)
        System.out.println(Math.random());
        System.out.println();


    }
}


