package com.sh.method;

/**
 * <pre>
 * method
 * - 특정 작업을 수행하기 위한 실행 코드의 집합
 * - 선언 후에 호출해서 사용한다.
 *
 * main method
 * -jvm에 의해 실행되는 자바프로그램 최초의 메소드\
 *
 * non-static 메소드 호출
 * - 객체를 만들고, 객체를 통해 호출
 *
 * static 메소드 호출
 * - 객체를 만들지 않고, 클래스 명으로 호출
 * </pre>
 */
public class App1 {

    /**
     * static 메소드
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main start...");

        // non-static 메소드 호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();

        // 2. 객체를 통해 호출
        app1.b();
        app1.a();
        app1.a();

        System.out.println("main end...");
    }

    /**
     * non-static 메소드
     */
    public void a(){
        System.out.println("a start...");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa...");
        System.out.println("a end...");
    }

    /**
     * non-static 메소드
     */
    public void b(){
        System.out.println("b start...");
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb...");
        c();
        System.out.println("b end...");
    }

    /**
     * non-static 메소드
     */
    public void c(){
        System.out.println("ccccccccccccccccc");
    }
}
