package com.sh.method;

/**
 * sgg java 출력
 */

public class App2 {
    public static void main(String[] args){
        //1. 객체생성
        App2 app = new App2();
        //2. 객체를 통해 메소드 호출
        app.s();
        app.s();
        app.g();
        System.out.println("");
        app.j();
        app.a();
        app.v();
        app.a();

    }

    public void a() {System.out.println("a");}
    public void g() {System.out.println("g");}
    public void j() {System.out.println("j");}
    public void s() {System.out.println("s");}
    public void v() {System.out.println("v");}

}
