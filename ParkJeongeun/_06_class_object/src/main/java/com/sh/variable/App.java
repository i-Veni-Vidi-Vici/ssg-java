package com.sh.variable;

/**
 * <pre>
 * 변수의 종류
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
 *   - 클래스 변수 (static변수) : 해당 클래스가 처음 사용된 시점 ~ 프로그램 종료
 *   - 인스턴스 변수 (non-static변수, 멤버변수) : 객체 생성 ~ 객체 제거
 * 2. 지역변수 : 메소드 안에서 선언된 변수 (메소드 호출 ~ 메소드 리턴)
 *   - 매개변수도 하나의 지역변수
 * </pre>
 */
public class App {
    private static int snum; // 클래스변수
    private int num; // 인스턴스변수

    public void test(int m){ // 지역변수
        int k; // 지역변수
    }
}
