package com.sh;
// package 관련된 클래스 묶음. 디렉토리
// 실제 클래스의 이름은 패키지를 포함. com.sh.HelloWorld
// 중복을 막기위해 domain을 뒤집어서 3레벨 이상 작성하는 관행이 있다.

// 한 줄 주석 - 코드로써 해석되지 않고 무시됨.
/*
    여러줄 주석
*/

/**
 * <h1>javadoc 주석</h1>
* <pre>
 * - 프로그램 문서에 기록될 주석.
*  - 클래스 / 메소드 / 필드 등에 작성.
* - html 문법 지원
* </pre>
**/
public class HelloWorld {

    /**
     * 메소드 -
     * */
    public static void main (String[] args) {
        System.out.println("안녕!");

    }
}
