package com.sh.method;

/**
 * <pre>
 * method
 * - 특정작업을 수행하기 위한 실행코드의 집합
 * - 선언 후에 호출해서 사용한다.
 *
 * main method
 * - jvm에 의해 실행되는 자바프로그램 최초의 메소드
 *
 * non-static 메소드 호출
 * - 객체(메모리조각)를 만들고, 객체를 통해 호출
 *
 * static 메소드 호출
 * - 객체를 만들지 않고, 클래스 명으로 호출
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
        // 1. 객체 생성
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();
        // 2. 객체를 통해 호출 - 메소드를 호출하는 순서에 따라 메소드의 출력 순서가 정해진다.
        // 따라서 메소드의 위치는 중요하지 않다.
        app1.b();
        app1.a();
        app1.a();
        System.out.println("main end...");
    }

    /**
     * non-static 메소드
     */
    public void a(){
        System.out.println("    a start...");

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...");

        System.out.println("    a end...");
    }
    /**
     * non-static 메소드
     */
    public void b(){
        System.out.println("    b start...");
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb...");
        // c메소드 호출 (non-static 메소드끼리는 객체지정 없이 호출 가능)
        c();
        System.out.println("    b end...");

    }

    public void c(){
        System.out.println("cccccccccccccccccccccccccc");
    }
}
