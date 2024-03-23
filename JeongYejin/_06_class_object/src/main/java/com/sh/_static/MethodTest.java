package com.sh._static;

/**
 * non-static 인스턴스 변수 : 객체생성시 ~ 객체소멸시
 * static 클래스 변수 : 프로그램 내에서 해당 클래스를 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 * 지역변수 : 메소드가 호출될 때 생성 ~ 메소드 실행 끝날 때 소멸
 * 생명주기가 static이 더 길다!
 * non-st : |----| |-----|       |----|
 * static : |-------------------------------|
 */

public class MethodTest {
    private static int s;
    private int n;

    /**
     * non-static 메소드에서는 non-static 필드, static 필드 모두 접근이 가능하다.
     */
    public void foo() {
        n ++;
        s ++;
        System.out.println("foo : " + n + ", " + s);
    }

    /**
     * static메소드에서는 static자원(필드/메소드)만 접근할 수 있다.
     */
    public static void bar() {
//        n++;
        s++;
//        System.out.println("bar : " + n + ", " + s);
    }
}
