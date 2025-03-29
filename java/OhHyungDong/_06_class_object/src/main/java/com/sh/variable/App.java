package com.sh.variable;

/**
 * <pre>
 * 변수 종류
 * 1. 전역변수 : 클래스 영역 안에서 선언된 변수
 *  - 클래스 변수(static 변수)
 *  생명주기 : 해당 클래스가 처음 사용된 시점 ~ 프로그램 종료
 *  - 인스턴스 변수(non - static 변수, 멤버변수 )
 *  생명주기 : 객체 생성 ~ 객체 제거
 * 2. 지역변수 : 메소드 안에서 선언된 변수 ,
 *  생명주기 : 메소드호출 ~ 메소드리턴
 *  - 메소드 안에 있는 매개변수도 지역변수임
 *
 *  짧은 생명주기를 가질수록 메모리 효율은 좋아진다.
 * </pre>
 */
public class App {
    private static int snum; //클래스 변수
    private int num;  //인스턴스 변수

    public void test(){
        int k ; //지역변수
    }
}
