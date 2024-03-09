package com.sh;
// package 관련된 클래스 묶음. 디렉토리
// 실제 클래스의 이름은 패키지를 포함. com.sh.HelloWorld
// 중복을 막기위해 domain을 뒤집어쓰는 3레벨 이상 작성하는 관행이 있다
// com.sh.Foo, com.sh.Foo(X)
// com.sh.Bar, com.ssh.Bar(0)

// 한줄 주석
/*
    여러줄 주석
 */

/**
 *
 * <h1> javadoc 주석 </h1>
 *
 * <pre>
 *      - 프로그램 문서에 기록될 주.
 *      - 클래스/메소드/필드 등에 작성.
 *      - html문법 지원
 * </pre>
 *
 */
public class HelloWorld {

    /**
     * 메소드 - 자바코드를 실행하는 가장작은 단위. 실행코드는 반드시 메소드안에 위치해야함.
     * main메소드 - 자바프로그램의 시작. main 메소드 안의 실행코드를 모두 처리하면 종료.
     * -Public static void main(String[] args) {}
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("안녕!");

    }
}
