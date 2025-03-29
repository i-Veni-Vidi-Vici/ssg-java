package com.sh._static;

/**
 * non - static : 인스턴스 변수(메소드) -> 생명주기 : 객체 생성 ~ 객체 소멸
 * static : 클래스 변수(메소드) : 프로그램에서 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 * -> non - static은 생명주기가 짧아서 static에서 이용하기가 힘듦.
 */
public class MethodTest {
    private int n;
    private static int s;

    /**
     * non - static 메소드에서는 non-static 변수, static 변수, 메소드  모두 접근이 가능하다.
     */
    public void foo(){
        n++;
        s++;
        System.out.println("foo : " + n + "," + s);
        bar();
    }

    /**
     * static 메소드에서는 non - static 변수는 접근이 불가능하다. static 메소드나 변수는 static끼리만 접근할 수 있음.
     */
    public static void bar(){
     s++;
    }
}
