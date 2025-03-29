package com.sh.variable;

/**
 * <pre>
 * 변수 종류
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
 *      - 클래스변수(static 변수) : 해당 클래스가 처음 사용된 시점 ~ 프로그램 종료
 *      - 인스턴스변수(non-static 변수, 멤버 변수; 인스턴스 안에 있는 필드 하나하나)
 *          : 객체 생성 ~ 객체 제거
 * 2. 지역변수 : 메소드 안에서 선언된 변수 : 메소드 호출 ~ 메소드 리턴 (가장 짧음)
 *      - 매개변수도 하나의 지역변수이다.
 *
 * 짧은 생명주기를 가질 수록 메모리 효율이 좋아짐
 * </pre>
 */
public class App {
    private static int snum; // 클래스 변수
    private int num; // 인스턴스 변수
    public void test(int m) {
        int k; // 지역변수
    }
}
