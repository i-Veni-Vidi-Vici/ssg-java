package com.sh.math;

/**
 * API
 * -Application Programming Interface
 * -운영체제/프로그래밍언어등이 제공하는 기능을 제어할 수 있도록 제공하는 인터페이스(규격)
 * -미리 만들어진 기능들을 가져다 쓰는방법
 * -API문서로 정리를 잘해두었으니 수시로 참고해서 적용할 것!
 *
 * MATH API
 * -수학관련 자주 사용하는 상수 혹은 기능들을 작성해둔 클래스
 * -모든 메소드는 static으로 구성되어 있다.
 * -절대값,올림,반올림,내림,난수생성 등
 */



public class App {
    public static void main(String[] args){
        //1.절대값
        System.out.println(Math.abs(-7));
        System.out.println(Math.abs(7));
        System.out.println(Math.abs(-9.9));
        //2.최대 최소값
        System.out.println(Math.max(10,20));
        System.out.println(Math.max(20,10));
        System.out.println(Math.min(10,20));
        System.out.println(Math.min(10,20));
        //3.난수 생성기
        System.out.println(Math.random());
        //4.math 관련 상수 제공
        System.out.println(Math.PI);
    }
}
