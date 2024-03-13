package com.sh.method;

/**
 * method
 * 특정작업을 수행하기 위한 실행코드의 집합
 * 선언 후에 호출해서 사용함.
 *
 * main method만 사용하고 있음
 * main method는 jvm에 의해 실행되는 자바프로그램 최초의 메소드임.
 *
 * method 호출 방식
 * - non-static 메소드 호출
 * 객체(메모리조각)를 만들고, 객체를 통해 호출함.
 *
 * - static 메소드 호출
 * 객체를 만들지 않고, 클래스 명으로 호출함
 *
 */

public class App1 {
    public static void main (String[] args){
        System.out.println("main start ...");
        // non-static 메소드 호출법
        // 1. 객체 생성 - 메소드를 가진 클래스를 객체로 만든다.
        // 클래스명 변수명 = new 클래스명();
        App1 app1 = new App1 ();

        // 2. 객체를 통해 호출
        app1.b();
        app1.a(); //소괄호 열고 닫고가 호출임
        app1.a();
        System.out.println("main end ...");

    }
    // main static 없음
    public void a() {

        System.out.println("    a start ...");

        System.out.println( "aaaaaaaaaaaaaaa ...");

        System.out.println("   a end ...");


        }
    public void b() {

            System.out.println("    b start ..." );
            System.out.println( "bbbbbbbbbbbb ...");
            System.out.println("   b end ...");

    }

    }

