package com.sh.variable;


/**
 * <pre>
 * 변수 종류
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
 *          - 클래스변수(static 변수) 해당 클래스 처음 사용된 시점 ~ 프로그램 종료 한번 올라가면 안 내려가잖아요
 *          - 인스턴스 변수 ( non -static변수, 멤버변수) 객체생성 ~ 객체제거
 * 2. 지역변수 : 메소드 영역에서 선언된 변수 메소드호출 ~ 메소드리턴 ( 제일 짧)
 *          - 매개변수도 하나의 지역변수이다.
 *
 * </pre>
 *
 *
 */
public class App {
    private static int snum; // 클래스 변수
    private int num; // 인스턴스 변수

    public void test(int m) {
        int k; // 지역변수
    }
}
