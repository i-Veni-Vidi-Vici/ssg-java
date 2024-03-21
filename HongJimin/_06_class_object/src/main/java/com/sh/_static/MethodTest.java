package com.sh._static;

/**
 *
 */
public class MethodTest {
    private static int s;
    private int n;

    /**
     * non-static 메소드에서는 non-static필드, static 필드 모두 접근이 가능하다.
     */


    public void foo() {
        n++;
        s++;
        System.out.println("foo : " + n + ", " + s);
        bar(); //non-static 메소드에서는 static 메소드 호출 가능
    }


    /**
     * static 메소드에서는 static 자원(필드/메소드)만 접근할 수 있다.
     */
    public static void bar() {
//        n++;
        s++;
//        System.out.println("bar : " + n + ", " + s);
//        foo();

    }
}
