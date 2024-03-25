package com.sh.variable;

/**
 * <pre>
 * 메모리를 계속, 오래 차지 하는게 안좋은거다 그러니깐 static을 잘 써야 한다
 * 변수 종류
 * 1. 전역변수 : 클래스 영역에서 선언된 변수
     - 클래스 변수(static변수) 해당클래스가 처음 사용된 시점~프로그램 종료까지
     - 인스턴스변수(non-static 변수, 멤버변수) 객체생성~객체제거
 * 2. 지역변수 : 메소드안에서 선언된 변수 메소드호출~메소드리턴
 *   - 매개변수도 하나의 지역변수 이다 -> test(int m)
 * </pre>
 */
public class App {
    private static int snum;// static 변수
    private int num;// 인스턴스 변수// new~ 할 때 마다 만들어진다

    public void test(int m) {
        int k;// 지역변수
    }
}
