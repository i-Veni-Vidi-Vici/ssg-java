package com.sh._static;

/**
 * non-static 인스턴스 변수 : 객체 생성 시 ~ 객체 소멸 시 (생명주기)
 * static 클래스 변수 : 프로그램에서 처음 사용 시(프로그램 시작 시) ~ 프로그램 종료
 */
public class MethodTest {
    private static int s;
    private int n;

    /**
     * not-static 메소드에서는 non-static필드, static필드 모두 접근 가능
     */
    public void foo(){
        n++;
        s++;
        System.out.println("foo : " + n + ", " + s);
    }

    /**
     * static 메소드에서는 static자원(필드/메소드)만 접근할 수 있다.
     */
    public static void bar(){
//        n++;
        s++;
//        System.out.println("bar : " + n + ", " + s));

    }

}
