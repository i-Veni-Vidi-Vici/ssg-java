package com.sh.variable;

/**
 * <pre>
 *     변수 종류
 *     1. 전역변수 : 클래스 영역에서 선언된 변수
 *      - 클래스 변수 (static 변수)
 *      - 인스턴스 변수 (non-static 변수, 멤버 변수)
 *     2. 지역변수 : 메소드 안에서 선언된 변수 / 메소드 호출시 ~ 메소드 리턴시 까지 존재
 *      - 매개변수도 하나의 지역변수다.
 *     메모리 효율 관점에서 볼때 짧은 생명주기를 가질수록 메모리 효율은 좋다
 *
 *
 * </pre>
 */
public class App{
    private static int snum;   //클래스 변수
    private int num;    //인스턴스 변수
    private void test(){
        int k;  //지역 변수
    }
}
