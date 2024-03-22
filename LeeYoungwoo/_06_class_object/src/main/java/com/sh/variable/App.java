package com.sh.variable;

/**
 * <pre>
 * 변수 종류
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
 *      - 클래스 변수(static변수), 생명주기 : 해당 클래스가 처음 사용된 시점 ~ 프로그램 종료
 *      - 인스턴스 변수(non-static변수, 멤버변수), 생명주기 : 객체생성 시점 ~ 객체제거
 * 2. 지역변수 : 메소드 영역에서 선언된 변수, 생명주기 : 메소드 호출 ~ 메소드 리턴
 *      - 매개변수도 하나의 지역변수이다.
 *      - 짧은 생명주기를 가질수록 메모리 사용은 적다.
 * </pre>
 */
public class App {
    private static int snum; // 클래스 변수
    private int num; // 인스턴스 변수
    public void test(int m ){ // m은 지역변수
        int k; // 지역변수
    }
}
