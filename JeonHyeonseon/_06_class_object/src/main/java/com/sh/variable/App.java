package com.sh.variable;

/**
 * <pre>
 * 변수의 종류 -> 생명주기도 기억하기
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
 *    - 클래스변수(static 변수)_해당 클래스가 생길때 생긴다. : 해당 클래스가 처음 사용된 시점 ~ 프로그램 종료까지
 *    - 인스턴스변수(non-static 변수, 멤버변수) : 객체생성시점 ~ 객체제거시점
 * 2. 지역변수 : 메소드 영역에서 선언된 변수 : 메소드호출 ~ 메소드리턴
 *    - 매개변수도 하나의 지역변수이다.
 *
 * ** 짧은 생명을 가질수록 메모리 효율은 좋다 **
 *
 * </pre>
 */
public class App {
    private static int snum;  // 클래스 변수(static 변수)
    private int num; // 인스턴스변수

    public void test(int m){   // m도 매개변수인데 이것 또한 지역변수이다.
        int k;  // 지역변수
    }
}
