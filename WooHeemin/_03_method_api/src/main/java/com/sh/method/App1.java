package com.sh.method;

/**
 *
 */
public class App1 {
    public static void main(String[] args) {
        System.out.println("main start...");
        // non-static method 호출법
        //1. 객체생성 - 메소드를 가진 클래스를 객첼 만든다.
        // 클래스명 변수
        App1 app1 = new App1();

        app1.a();
    }

    /**
     * non-statit method
     */

    public void a() {
        System.out.println(" a start...");
    }
}