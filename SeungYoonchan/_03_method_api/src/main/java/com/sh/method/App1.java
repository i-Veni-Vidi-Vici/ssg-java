package com.sh.method;

/**
 * <h3>Method</h3>
 * <pre>
 *     - 특정 작업을 수행하기 위한 실행 코드의 집합
 *     - 선언 후에 호출해서 사용한다.
 *
 *     Main method
 *     - jvm에 의해 실행되는 자바 프로그램 최초의 메소드
 *
 *     non-static method
 *     - 객체를 만들고, 객체를 통해 호출
 *
 *     static method
 *     - 객체를 만들지 않고, 클래스 명으로 호출
 *
 * </pre>
 */

public class App1 {
    /**
     * static 메소드
     * @param args
     */
    public static void main (String[] args){
        System.out.println("\nMain Start...");
        // non-static 메소드 호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();
        // 2. 객체를 통해 호출
        app1.a();
        app1.b();

        System.out.println("\nMain End...");
    }

    /**
     * non-static 메소드
     */
    public  void a() {
        System.out.println("\n\ta start...");

        System.out.println("\tThis is a method");

        System.out.println("\ta end...");
    }

    public void b() {
        System.out.println("\n\tb start...");

        System.out.println("\tThis is b method");

        System.out.println("\tb end...");
    }
}
