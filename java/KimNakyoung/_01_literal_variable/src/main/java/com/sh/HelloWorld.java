package com.sh;
// package 관련된 클래스 묶음. 실제로 디렉토리 폴더
// 실제 클래스의 이름은 패키지를 포함. com.sh.HelloWorld
// 소문자시작 패키지 대문자 시작 클래스
// 중복을 막기위해  domain을 뒤집어서 3레벨이상 작성하는 관행이있다.
// com.sh.Foo , com.sh.Foo (X) 둘이 같아서
// com.sh.Bar, com.ssg.Bar (O) 패키지명 달라서 다른거라
// 한줄

/*
여러줄 주석
 */

/**
 *  javadoc 주석 - 프로그램 문서에 기록될 주석. 클래스/메소드 등에 작성 html문법 지원
 */

/**
 *
 *
 * <pre> 개행 (줄바꿈)
 * -프로그램 누서에 기록될 주석
 * - 클래스/메소드/필드 등에 작성
 * - html 문법 지원
 * </pre>
 */


public class HelloWorld {

    /**
     * 메소드 - 자바 코드를 실행하는 가장 작은 단위. 실행코드는 반드시 메소드안에 위치해야함
     * main메소드 - 자바프로그램의 시작. main메소드 안의 실행코드를 모두 처리하면 종료.
     * - public static void main(String[] args){} 정확히 작성해야한다.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("안녕!");
    }
}
