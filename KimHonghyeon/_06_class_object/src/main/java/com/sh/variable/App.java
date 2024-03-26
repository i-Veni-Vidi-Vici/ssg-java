package com.sh.variable;

/**
 * 변수 종류 및 scope
 *
 * 1. 전역변수: 클래스 내에 선언된 변수
 *      - 클래스 변수(=static 변수) / 클래스 사용시작~프로그램종료
 *      - 인스턴스 변수(=non-static 변수, 맴버변수) / 객체생성~객체제거
 * 2. 지역변수: 메소드 내에서 선언된 변수 / 메소드 호출~메소드 종료
 *      - 매개변수도 지역변수
 */
public class App {
    private static int staticVar;  // static 변수
    private int instanceVar;  // instance 변수

    public void test(){
        int localVar;  // local 변수
        //매개변수도 지역변수
    }

}
