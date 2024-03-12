package com.sh;
// package 관련된 클래스의 묶음. 그룹핑의 목적. 말이 패키지지 디렉토리
// 실제 클래스의 이름은 패키지를 포함. ex) com.sh.HelloWorld
// 패키지는 소문자고 단어 단위로 끊기고. 대문자로 시작하면 class
// 중복을 막기위해 domain을 뒤집어서 3레벨이상(폴더 3개) 작성하는 관행이 있다
//패키지 com.sh.Foo, 클래스 com.sh.Foo (x) 패키지명과 클래스명이 동일해서는 안된다.
// 패키지com.sh.Bar, 클래스 com.ssg.Bar (o)

// 한 줄 주석
/*
    여러줄 주석
 */

/**
 * <h1>javadoc 주석</h1>
 *
 * <pre>
 *     javadoc 주석 - 프로그램 문서에 기록될 주석.
 *     클래스/메소드/필드 등에 작성.
 *     HTML문법 지원
 * </pre>
 *
 */
public class HelloWorld {

    /**
     * 메소드 - 자바 코드를 실행하는 가장 작은 단위. 실행코드는 반드시 메소드 안에 위치해야함
     * main메소드 - 자바프로그램의 시작. main메소드 안의 실행코드를 모두 처리하면 종료.
     * - public static void main(String[] args){} 정확히 작성해야 한다.
     * @param args
     */
    public static void main(String[] args){
         System.out.println("안녕하세요");
    }
}
