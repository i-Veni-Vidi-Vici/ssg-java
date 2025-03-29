package com.sh.variable;

/**
 * <pre>
 * 변수 종류
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
 *        - 클래스 변수(static 변수) 해당클래스 처음 사용된 시점 ~ 프로그램 종료
 *        - 인스턴스 변수(non-static변수, 멤버변수) new연산자로 객체 생성시~ 객체 제거
 * 2. 지역변수 : 메소드 영역에서 선언된 변수. 메소드호출~메소드 리턴
 *        - 매개변수도 하나의 지역변수다.
 * 짧은 생명주기를 가질수록 메모리 효율은 좋아진다.
 * </pre>
 */
public class App {
    private static int snum; // 클래스 변수
    private int num; // 인스턴스 변수

    public void test(int m){ // 매개변수 m도 지역변수
        int k;// 지역변수
    }
}
