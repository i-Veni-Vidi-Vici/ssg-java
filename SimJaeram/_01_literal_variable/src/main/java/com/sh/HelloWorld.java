package com.sh;
// package 관련된 클랫 묶음 단위. 디렉토리. 자바 소스파일 맨 윗줄에 패키지 선언.
// 실제 클래스의 이름은 패키지를 포함. com.sh.HelloWorld
// 패키지는 단어 단위로 끊어서, 소문자로
// 클래스는 각 단어마다 대문자로 시작
// 중복을 막기 위해 domain을 뒤집어 3레벨 이상 즉, 폴더 3개 이상 작성하는 관행이 있다.
// 한줄 주석 - 코드로써 해석되지 않고 무시됨.
// com.sh.Foo, com.sh.Foo (x)
// com.sh.Bar, com.ssg.Bar (o)

/*
 여러줄 주석
 */

/**
 *  <h1>javadoc 주석 </h1>
 *
 *  <pre>
 *  - 프로그램 문서에 기록될 주석.
 *  - 클래스/메소드/필드 등에 작성.
 *  - html 문법 지원
 *  </pre>
 */

public class HelloWorld {

    /**
     * 메소드 - 자바 코드를 실행하는 가장 작은 단위. 실행콛드는 반드시 메소드 안에 위치해야함.
     * main 메소드 - 자바 프로그램의 시작. main 메소드 안의 실행 코드를 모두 처리하면 종료.
     */
    public static void main(String[] args) {
        System.out.println("안녕!");
    }
}
