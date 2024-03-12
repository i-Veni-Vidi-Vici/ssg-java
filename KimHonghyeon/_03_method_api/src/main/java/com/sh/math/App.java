package com.sh.math;

/**
 * Math API(Application Programming Interface)
 * - 운영체제/프로그래밍 언어 등이 제공하는 기능을 제어할 수 있도록 제공하는 인터페이스
 * - 미리 만들어진 기능을 가져다 쓰는 방법
 * - 수학관련 자주 사용하는 상수 혹은 기능들을 작성해둔 클래스
 * - 모든 메소드는 staatic으로 구성
 * - 절댓값, 올림, 반올림, 내림, 난수 생성 등
 *
 */
public class App {
    public static void main(String[] args) {
        //1.절댓값
        System.out.println(Math.abs(-7));
        System.out.println(Math.abs(7));
        System.out.println(Math.max(10,20));
        System.out.println(Math.min(10,20));
        System.out.println(Math.random());
        System.out.println(Math.random()*10);
        System.out.println(Math.PI);
    }
}
