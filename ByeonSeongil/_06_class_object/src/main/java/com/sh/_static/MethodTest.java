package com.sh._static;

/**
 * non-static 인스턴스 변수 : 객체생성시 ~ 객체소멸시
 * static 클래스 변수 : 프로그램에서 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 * 생성주기가 다르기때문에 static 변수는 제한이 존재함
 */
public class MethodTest {

    private static int s;
    private int n;

    /**
     * non-static 메서드에서는 non-static필드, static필드 모두 접근이 가능핟.
     */
    public void foo() {
        n++;
        s++;
        System.out.println("foo : " +n +", "+s);
        bar();
    }

    /**
     * static메서드에서는 static자원(필드/메서드)만 접근할 수 있다.
     */
    public static void bar() {
//        n++;
        s++;
//        System.out.println("bar : "  +n +s);
    }
}
