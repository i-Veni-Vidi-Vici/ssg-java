package com.sh._static;

/**
 * non-static 인스턴스 변수: 객체 생성시 ~ 객체 소멸시
 * static 클래스 변수: 프로그램에서 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 */
public class MethodTest {
    private static int s;
    private int n;
    /**
     * non-static 메소드에서는 non-static 필드, static 필드 모두 접근이 가능하다.
     */
    public void foo() {
        s++;
        n++;
        System.out.println("foo: " + n + ", " + s);
    }

    /**
     * static 메소드에서는 static 자원(필드/메소드)만 접근할 수 있다.
     */
    public static void bar() {
        // System.out.println("foo: " + n + ", " + s);
    }
}
