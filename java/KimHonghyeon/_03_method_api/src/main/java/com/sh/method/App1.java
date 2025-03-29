package com.sh.method;

public class App1 {
    /**
     *
     * method : 특정 작업을 수행하기 위한 실행코드의 집합
     * - 선언 후에 호출하여 사용
     *
     * main method : JVM에 의해 실행되는 자바프로그램의 최초 메소드
     *
     * Non-static method 호출
     * - 객체를 만들고 객체를 통해 호출
     *
     * static method
     * - 객체를 만들지 않고 클래스 명으로 호출
     */

    //static method
    public static void main(String[] args) {
        System.out.println("main() start");
        //non-static method 호출
        //1.객체 생성
        App1 app = new App1();
        //2.객체 통해 호출
        app.a();
        app.b();
        System.out.println("main() end");
    }

    //non-static method
    public void a(){
        System.out.println("a() start");
        System.out.println("Do something in a()");
        System.out.println("a() end");

    }
    public void b(){
        System.out.println("b() start");
        System.out.println("Do something in b()");
        c(); //객체 생성 없이 호출 가능 -> non-static method 사이에서
        System.out.println("b() end");

    }

    public void c(){
        System.out.println("c() start");
        System.out.println("Do something in c()");
        System.out.println("c() end");

    }

}
