package com.sh;
// package 관련된 클래스 묶음. 실제로는 디렉토리같은 개념이다
// package 우클릭-> open in -> explore는 실제 폴더가 나온다
// 실제 클래스의 이름은 패키지를 포함.
// 한 줄 주석 - 코드로써 해석되지 않고 무시됨.
// 보통 클래스는 대문자, 소문자는 패키지
// 중복을 막기위해 domain을 뒤집어서 3레벨(폴더개수) 이상 작성하는 관행이 있다.
// com.sh.Foo - com.sh.Foo 안됨
// com.sh.Foo - com.ssg.Foo 이건 됨
/*
 이건 여러줄 주석입니다
 */

/**
 * <pre>
 *   - <h2>javadoc 주석- 프로그램 문서에 기록될 주석</h2> <- 이러면 글씨가 커진다
 *
 *   - 클래스/메소드/필드 등에 작성.
 *   - html문법 지원도 합니다
 *   </pre>
*/

public class HelloWorld {

    /**
     * 메소드(도구) - 자바 코드를 실행하는 가장 작은 단위.
     * 실행코드는 반드시 메소드안에 위치해야합니다
     * main메소드 - 자바프로그램의 시작. main메소드 안의 실행코드를 모두 처리하면 종료됨
     * public static void main (String[] args) 정확히 타이핑 해야됨, 대문자 안됨
     * @param args
     */
    public static void main (String[] args)
    {
        System.out.println("Helloworld 클래스 입니다");
    }
}

