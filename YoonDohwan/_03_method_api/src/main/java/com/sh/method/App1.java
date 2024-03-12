package com.sh.method;
/**
 <pre>
 method
 -특정작업을 수행하기 위한 실행코드의 집합
 -선언후에 호출해서 사용한다.

 main method
 -jvm에 의해 실행되는 자바프로그램 최초의 메소드

 -non-static메소드 호출
 -객체를 만들고, 객체를 통해 호출
 -static 메소드 호출
 -객체를 만들지 않고, 클래스 명으로 호출
 </pre>



 */
public class App1 {
    /*
    static 메소드
     */
    public static void main(String[] args){
        System.out.println("main start");
        //non-static 메소드 호출법
    //1.객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        //클래스명 변수명 = new 클래스명();
        App1 app1 = new App1();
        app1.a();
        app1.b();
        System.out.println("main end");
    //2.객체를 통햏 호출
    }
    public void a(){
        System.out.println("a start...");
        System.out.println("aaaaaaaaaaaa");

    }

    public void b(){
        System.out.println("b start");
        //c메소드 호출(non-static 메소드끼리만 객체지정 없이 호출가능)
        c();
        System.out.println("bbbbbbbbbb");
    }
    public void c(){
        System.out.println("cccccccccc");
    }

}
