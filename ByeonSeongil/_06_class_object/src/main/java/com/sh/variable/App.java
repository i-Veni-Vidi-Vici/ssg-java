package com.sh.variable;

/**
 * <pre>
 * 변수 종류
 * 1. 전역 변수: 클래스 영역에서 선언된 변수
 *      - 클래스 변수(static변수) => 해당클래스 처음 사용된 시점 ~ 프로그램 종료
 *      - 인스턴스 변수(non-static변수, 멤버 변수) => 객체 생성 ~ 객체제거
 * 2. 지역 변수: 메서드 영역에서 선언된 변수 => 메서드 호출 ~ 메서드 리턴
 *      - 매개변수도 하나의 지역변수이다.
 * </pre>
 */
public class App {
    private static int snum; // 클래스 변수
    private int num; // 인스턴스 변수

    public void test(int m) {
        int k; // 지역변수
    }

}
