package com.sh.method;

/**
 * <pre>
 * method
 * - 특정작업을 수행하기 위한 실행코드의 집합
 * - 선언후에 호출해서 사용한다.
 *
 * main method
 * - jvm에 의해 실행되는 자바프로그램 최초의 메소드
 * - jvm은 실행 명령을 받고 main method를 찾는다
 *
 * non-static메소드 호출
 * - 객체를 만들고, 객체를 통해 호출
 *
 * static 메소드 호출
 * - 객체를 만들지 않고, 클래스 명으로 호출
 * </pre>
 */

public class App1 {
    /**
     * non-static 메소드
     * 메소드의 작성 순서는 중요하지 X
     */
    public void a() {
        System.out.println("    a start...");

        System.out.println("    aaaaaaaaaaaaaaaaaaaaaaaaa...");

        System.out.println("    a end...");
    }

    public void b() {
        System.out.println("    b start...");
        System.out.println("    bbbbbbbbbbbbbbbbbbbbbbbbb...");
        c(); // non-static 메소드끼리는 객체를 만들지 않아도 호출 가능
        System.out.println("    b end...");
    }

    public void c() {
        System.out.println("    ccccccccccccccccccccccccc...");
    }
    /**
     * static 메소드
     */
    public static void main(String[] args) {
        System.out.println("main start...");
        // non-static 메소드 호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();
        // 2. 객체를 통해 호출
        app1.a(); // 소괄호 : 호출
        app1.b();
        System.out.println("main end...");
    }
}
