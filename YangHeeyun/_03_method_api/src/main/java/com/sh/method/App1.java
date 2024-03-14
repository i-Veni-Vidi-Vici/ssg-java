package com.sh.method;

/**
 * <pre>
 * method (함수와 비슷함)
 * - 특정 작업을 수행하기 위한 실행코드의 집합
 * - 선언 후에 호출해서 사용한다.
 *
 * main method
 * - jvm에 의해 실행되는 자바 프로그램 최초의 메소드
 *
 * method 2가지 호출방식
 * static 메소드 호출
 * - 객체를 만들지 않고 클래스 명으로 호출
 * non - static 메소드 호출
 * - 객체(메모리 조각)를 만들고, 객체를 통해 호출
 *
 * </pre>
 */
public class App1 {
    /**
     * main은 static 메소드
     */
    // non-static 메소드
    public void a() {
        System.out.println("    a start...");
        System.out.println("aaaaaaaaaaaaa...");
        System.out.println("    a end...");
    }
    public void b() {
        System.out.println("    b start...");
        System.out.println("bbbbbbbbbbbb...");
        // c 메소드 호출 (non-static 메소드끼리는 객체지정 없이 호출 가능)
        c();
        System.out.println("    b end...");
    }
    public void c() {
        System.out.println("cccccccccccc...");
    }

    public static void main(String[] args) {
        System.out.println("main start...");
        // non-static 메소드 호출법
        // 1. 객체생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app = new App1();
        // 2. 객체를 통해 호출
        app.b(); // app1 안에 있는 a를 호출해줌
        app.a();
        app.a();
        System.out.println("main end...");

    }





}
