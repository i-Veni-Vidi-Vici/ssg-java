package com.sh.math;


/*
API
application programming Interface
운영체제/프로그래밍언어등이 제공하는 기능을 제어할 수 있도록 제공하는 인터페이스 (규격)

Math.api
수학관련 자주 사용하는 상수 혹은 기능들을 작성해둔 클래스
모든 메소드는 static으로 구성되어 있다.
절댓값 올림 반올림 내림 난수생성
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Math.abs(-7));
        System.out.println(Math.abs(+8));
        System.out.println(Math.abs(-9.9));

        System.out.println(Math.max(10, 20));
        System.out.println(Math.max(20, 10));
        System.out.println(Math.min(10, 20));
        System.out.println(Math.min(20, 10));

        //난수 생성:0.0이상 ~1.0미만의 난수(double)반환
        System.out.println(Math.random());

    }
}
