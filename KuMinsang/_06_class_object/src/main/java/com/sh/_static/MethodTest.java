package com.sh._static;

/**
 * non-static 인스턴스 변수 : 객체 생성시 ~ 객체소멸시
 * static 클래스 변수 : 프로그램에서 처음 사용시 부터 프로그램 종료시 까지
 * static에서 non-static을 호출할수 없는 이유는 static이 생성된 시점에 non-static의 객체가 존재하지 않을수 있으며, static이 소멸할때까지 non-static을 유지해야 하므로 non-static의 설계 목적을 상실한다
 *
 *
 */

public class MethodTest {
    private static int s;
    private int n;

    /**
     * non-static 메소드 에서는 non-static필드. static필드 모두 접근이 가능하다
     */

    public void foo(){
        n++;
        s++;
        System.out.println("foo : " + n + ", " + s);
        //bar() 가능
    }

    /**
     * static 메소드에서는 static 자원(필드/메소드)만 접근할 수 있다
     */
    public static void bar(){
        s++;
        // foo() 불가함
    }
}
