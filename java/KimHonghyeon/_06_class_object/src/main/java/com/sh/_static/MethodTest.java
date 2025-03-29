package com.sh._static;

public class MethodTest {
    private static int s;
    private int n;

    /**
     * non-static 메소드는 static, non-static 맴버 모두 접근 가능
     */
    public void foo(){
        System.out.println("n = " + n);
        System.out.println("s = " + s);
    }

    /**
     * static 메소드는 static 멤버만 접근 가능
     */
    public static void bar(){
        System.out.println("s = " + s);
    }
}
