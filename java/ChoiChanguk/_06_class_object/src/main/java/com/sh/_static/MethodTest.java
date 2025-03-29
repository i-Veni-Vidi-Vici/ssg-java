package com.sh._static;
/**
 * non-static=인스턴스 변수 : 객체생성시 ~ 객체소멸시
 * static 클래스 변수 : 프로그램에서 처음 사용시 메모리에 적재 ~ 프로그램 종료시 까지
 */
public class MethodTest {
    private static int s;
    private int n;
    /**
     * non-static메소드에서는 non-static필드, static필드 모두 접근 가능하다
     */
    public void foo() {
        s++;
        n++;
        System.out.println("foo : "+n+", "+s);
    }
    /**
     * static메소드에서는 static자원(필드/자원)만 접근 할 수 있다.
     * static은 static끼리만 사용가능 = 프로그램 자원 수명주기
     */
    public static void bar() {
        //n++;
        s++;
    }
}
