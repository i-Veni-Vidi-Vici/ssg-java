package com.sh.method;


/**
 * <pre>
 * method
 * - 특정작업을 수행하기 위한 실행코드의 집합
 * - 선언후에 호출해서 사용한다.
 *
 * main method
 * - jvm에 의해 실행되는 자바프로그램 최초의 메소드 (여기있는 코드 다 실행하면 종료)
 *
 * non-static 메소드 호출
 * - 객체(메모리 조각)를 만들고, 객체를 통해 호출
 *
 * static 메소드 호출
 * - 객체를 만들지 않고, 클래스 명으로 호출
 *
 ** 객체지향언어 -> Object Oriented Language 객체(메모리조각)를 향한 언어
 *
 * </pre>
 *
 */
public class App1 {
    /**
     * non-static 메소드
     */

    // 메소드의 선언 순서는 상관없다.  main 위에 있던 아래에 있던
    // 메소드흐름 call(호출) 과 메소드 끝나면 return

    public void a(){
        System.out.println("    a start...");

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...");

        System.out.println("    a end...");

    }

    /**
     * non-static 메소드
     */

    public void b() {
        System.out.println("    b start...");

        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb...");
        // c메소드 호출(non-static메소드끼리는 객체지정 없이 호출 가능)

        c();

        System.out.println("    b end...");

    }

    /**
     * static
     *
     */


    public static void main(String[] args) {
        System.out.println("main start...");

        // non-static 메소드 호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();

        // 2. 객체를 통해 호출
        app1.a(); // app1. 하면 메소드 목록 나옴 '()'은 호출
        app1.b();
        app1.a(); // 메소드 여러번 호출가능

        System.out.println("main end...");

    }

    public void c() {
        System.out.println("    c start...");

        System.out.println("ccccccccccccccccccccccccc...");

        System.out.println("    c end...");


    }






}
