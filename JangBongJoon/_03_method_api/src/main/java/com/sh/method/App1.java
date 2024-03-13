package com.sh.method;

public class App1 {
    public static void main(String[] args) {
        System.out.println("main start");
/*        non-static 메서드 호출법
                1.객체생성 메소드를 가진 클래스를 객체로 만든다.*/
        App1 app1 = new App1();
        /*2객체를 통해 호출*/
        app1.a(); //a를 실행시켜줘

        System.out.println("main end");
    }

    public void a() {
        System.out.println("    a start");

        System.out.println("aaaaaaaaaaaaaaaaa...");

        System.out.println("    a end");

    }
}
