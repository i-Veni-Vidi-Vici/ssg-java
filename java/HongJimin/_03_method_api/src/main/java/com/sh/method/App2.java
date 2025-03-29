package com.sh.method;


/**
 * ssg java 출력
 */
public class App2 {
    public static void main(String[] args) {
        //1. 객체 생성
        App2 app2 = new App2();

        //2. 객체를 통해 메소드 호출
        app2.s();
        app2.s();
        app2.g();
        System.out.print(" ");
        app2.j();
        app2.a();
        app2.v();
        app2.a();
    }

    public void a() {System.out.print("a");}
    public void j() {System.out.print("j");}
    public void g() {System.out.print("g");}
    public void s() {System.out.print("s");}
    public void v() {System.out.print("v");}
}
