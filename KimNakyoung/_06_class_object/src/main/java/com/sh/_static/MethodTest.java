package com.sh._static;

/**
 * non-static 인스턴스 변수 : 객체생성시(힙) ~ 객체소멸시
 * static 클래스 변수 : 프로그램에서 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 * // static이 올라가있을 때 non-static이 없을 수도 있음 그래서 막힘 !!
 *
 */
public class MethodTest {


    private static int s;

    private int n;

    /**
     * non-static 메소드에서는 non-static필드. static 필드 모두 접근이 가능하다.
     */
    public void foo(){
        n++;
        s++;
        System.out.println("foo : " + n + "," + s);
        bar();

    }

    /**
     * static 메소드에서는 static자원(필드/메소드)만 접근 할 수 있다.
     */


    public static void bar(){
//        n++;
//        s++;
//        System.out.println("bar :" + n + "," + s);
//        foo();
//        abc(); // static -> non-static
        xyz(); // static -> static
        // 원래는 클래스.메소드 인데 같은 클래스라서 생략~



    }

    public void abc(){}

    public static void xyz(){}
}
