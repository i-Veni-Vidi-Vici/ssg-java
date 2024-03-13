package com.sh.method;

/**
 * <pre>
 * method
 * - 특정작업을 수행하기 위한 실행코드의 집합
 * - 선언후에 호출해서 사용한다.
 *
 * main method
 * - jvm에 의해 실행되는 자바프로그램 최초의 메소드
 *
 * method 호출방식
 * 1. non-static 메소드 호출
 *  - 객체(메모리 조각)를 만들고, 객체를 통해 호출
 *
 * 2. static 메소드 호출
 *  - 객체를 만들지 않고, 클래스 명으로 호출
 *
 * </pre>
 */
public class App1 {
    /**
     * static 메소드
     */
    public static void main(String[] args) {
        System.out.println("main start...");
        // non-static 메소드 호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();
        // 2. 객체를 통해 호출 -> a() 이렇게 뜨는게 호출이다.
        app1.b();
        app1.a();
        app1.a();

        System.out.println("main end...");
    }

    /**
     * non-static 메소드
     * non-static 메소드의 선언은 순서와 상관이 없다
     * -> static 메소드에서 객체지정 후 호출하는 순서대로 들어가는것일 뿐
     */
    public void a() {
        System.out.println("    a start...");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa...");
        System.out.println("    a end...");
    }

    /**
     * non-static 메소드
     */
    public void b() {
        System.out.println("    b start...");
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbb...");
        // c 메소드 호출 (non-static 메소드 끼리는 객체지정 없이 호출 가능)
        c();
        System.out.println("    b end...");
    }

    public void c() {
        System.out.println("cccccccccccccccc");
    }
}
