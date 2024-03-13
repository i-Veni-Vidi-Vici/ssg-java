package com.sh.method;

/**
 * ssg java 출력
 */
public class App2 {
    public static void main(String args[])
    {
        // 1. 객체생성
        App2 app= new App2();
        // 2. 객체를 통해 메소드 호출
        app.s();
        app.s();
        app.g();
        System.out.print(' ');
        app.j();
        app.a();
        app.v();
        app.a();
    }
    public void a() {System.out.print("a");}
    public void g() {System.out.print("g");}
    public void j() {System.out.print("j");}
    public void s() {System.out.print("s");}
    public void v() {System.out.print("v");}
}
