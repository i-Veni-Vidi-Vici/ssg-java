package com.sh.operator;
// package 관련된 클래스 묶음. 디렉토리
// 실제 클래스의 이름은 패키지를 포함. com.sh.HelloWorld
// 중복을 막기위해 domain을 3레벨 이상 뒤집어쓰는 관행이 있다.
// com.sh.Foo, com.sh.Foo (x)
// com.sh.Bar, com.ssg.Bar(O)

// 한줄 주석!!!
/* 여러줄 주석!!!
아아아아아아아
아아으아아아아
으ㅏ으아ㅡㅏ으ㅏ으ㅏ으ㅏㅡㅇ 주석 주석

 */

/**
 * <h1>javadoc 주석 </h1>
 *
 * <pre>
 * - 프로그램 문서에 기록될 주석.
 * - 클래스/메소드/필드 등에 작성.
 * - html 문법도 지원
 */
public class HelloWorld {
    /**
     * 메소드 - 자바 코드를 실행하는 가장 작은 단위, 실행코드는 반드시 메소드안에 위치해야함.
     * main 메소드 - 자바프로그램의 시작. main메소드 안의 실행코드를 모두 처리하면 종료
      * @param args
     */
    public static void main (String[] args) {
        System.out.println("안녕!!");
    }
}
