package com.sh._static;

/**
 * non-static 인스턴스 변수의 생명주기(메모리상) : 객체 생성시 ~ 객체 소멸시
 * static 클래스 변수의 생명주기 : 프로그램에서 처음 사용시(프로그램 시작시) ~ 프로그램 종료
 */

public class MethodTest {
    private static int s;
    private int n;

    /**
     * static 메소드에서는 static자원(필드/메소드)만 접근 가능
     */
    public static void bar(){
//        n++; // n 오류
        s++;
//        System.out.println("foo : " + n + ", " + s); // n 오류
//        foo(); // 호출X
    }

    /**
     * non-static 메소드에서는 non-static, static 필드 모두 접근 가능
     */
    public void foo(){
        n++;
        s++;
        System.out.println("foo : " + n + ", " + s);
        bar();
    }
}
