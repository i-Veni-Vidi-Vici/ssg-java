package com.sh._static;

/**
 * <pre>
 * non-static 인스턴스 변수 : 객체생성시 ~ 객체소멸시까지 사용가능
 * static 클래스 변수 : 프로그램에서 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 * </pre>
 */
public class MethodTest {
    private static int s;
    private int n;

    /**
     * non-static메소드에서는 non-stacit필드 static필드 모두 접근이 가능하다.
     */
    public void foo(){
        n++;
        s++;
        System.out.println("foo : " + n + "," + s);
        bar();
    }

    /**
     * static메소드에서는 static자원(필드/메소드)만 접근할 수 있다.
     */
    public static void bar(){
//        n++;
        s++;
//        foo();
    }
}
