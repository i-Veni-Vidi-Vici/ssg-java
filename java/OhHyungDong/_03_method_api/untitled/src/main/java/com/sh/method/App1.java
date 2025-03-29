package com.sh.method;

/**
 * <pre>
 *   method
 *   - 특정작업을 수행하기 위한 실행코드의 집합
 *   - 선언 후, 호출해서 사용
 *
 *   main method
 *   - jvm에 의해서 실행되는 자바프로그램 최초의 메소드
 *
 *   static 메소드 호출
 *   - 객체를 만들지 않고, 객체를 통해 호출
 *
 *   non - static 메소드 호출
 *   - 객체를 만들고, 객체를 통해 호출
 * </pre>
 */
public class App1
{
    //main 메소드 => jvm이 호출함.
    public static void main(String[] args) {
        System.out.println("main start...");
       //nont - static 메소드 호출법
       // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        App1 app1 = new App1(); // 클래스명 변수명 = new 클래스명();

        // 2. 객체를 통해 호출
        app1.a(); // a 메소드는 static 메소드여서 객체를 통해 호출하지 않고 그냥 호출해도된다.
        app1.b();
        System.out.println("main end..");
    }

    public static void a(){
        System.out.println(" a start");
        System.out.println("aaaaaa");
        System.out.println("a end ");
    }

    /**
     * non - static method
     */
    public void b(){
        System.out.println(" b start");
        System.out.println("bbbbbb");
        System.out.println("b end ");
        c(); // c 메소드 호출 (non - static 메소드끼리는 객체 지정없이 호출 가능함.
    }
    public void c(){
        System.out.println(" c start");
        System.out.println("cccc");
        System.out.println("c end ");
    }

}
