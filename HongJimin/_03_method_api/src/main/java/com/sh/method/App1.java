package com.sh.method;

/**
 *
 */
public class App1 {
    /**
     * static 메소드
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main start...");

        //호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        //클래스 명 변수명 =  new 클래스 명();
        App1 app1 = new App1();
        // 2.객체를 통해 호출
        app1.a();
        app1.b();


        System.out.println("main end...");
    }

    /**
     * non-static 메소드
     */
    public void a() {
        System.out.println("  a start...");

        System.out.println("aaaaaaaaaaaaaaaaaa");

        System.out.println("  a end...");

    }

    /**
     * non-static 메소드
     */
    public void b() {
        System.out.println("   b start...");
        System.out.println("bbbbbbbbbbbbbbbbb");
        //c 메소드 호출 (non-static 메소드끼리는 객체 지정 없이 호출 가능)
        c();
        System.out.println("   b end...");
    }

    public void c() {
        System.out.println("cccccccccccccc");
    }
}
