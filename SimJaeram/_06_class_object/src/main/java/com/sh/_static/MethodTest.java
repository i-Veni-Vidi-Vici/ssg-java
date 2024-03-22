package com.sh._static;

public class MethodTest {
    private static int s;
    private int n;

    /**
     * non-static 메소드에서는 non-static필드, static필드 모두 접근 가능
     */
    public void foo() {
        n++;
        s++;
        System.out.println("foo : " + n + ", " + s);
        foo();
    }

    /**
     * static 메소드에서는 static 자원(필드/메소드)만 접근할 수 있다.
     */
    public static void bar() {
//        n++;
        s++;
//        System.out.println("foo : " + n + ", " + s);
    }
}
