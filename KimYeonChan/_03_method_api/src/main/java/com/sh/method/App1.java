package com.sh.method;

/**
 * method
 * - 특정 작업을 수행하기 위한 실행코드의 집합.
 * - 선언 후에 호출하여 사용한다.

 * main method
 * - jvm 에 의해 실행되는 자바프로그램 최초의 메소드

 * non-static 메소드 호출
 * - 객체를 만들고, 객체를 통해 호출
 * static 메소드 호출
 * - 객체를 만들지 않고, 클래스명으로 호출

 * 객체지향언어
 * - Object Oriented Language
 * - Object Oriented Programming
 * - 객체란 메모리 조각이다.
 */
public class App1 {
    /**
     * static 메소드
     */
    public static void main(String[] args) {
        System.out.println("main start ...");
        // non-static 메소드 호출법
        // 1. 객체 생성: 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();
        // 2. 객체를 통해 호출
        app1.a();
        app1.b();

        System.out.println("main end ...");
    }

    /**
     * non-static 메소드
     */
    public void a() {
        System.out.println("    a start ...");
        System.out.println("    a running ...");
        System.out.println("    a end ...");
    }

    /**
     * non-static 메소드
     */
    public void b() {
        System.out.println("    b start ...");
        System.out.println("    b running ...");
        // c 메소드 호출(non-static 메소드끼리는 객체지정 없이 호출 가능
        c();
        System.out.println("    b end ...");
    }

    public void c() {
        System.out.println("        c start ...");
        System.out.println("        c running ...");
        System.out.println("        c end ...");
    }
}
