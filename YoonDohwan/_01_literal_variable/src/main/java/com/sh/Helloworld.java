package com.sh;
//package 관련된 클래스 묶음. 디렉토리폴더 느낌
//실제클래스의 이름은 패키지를 포함.  com.sh.Helloworld 패키지는 소문자 클래스는 대문자시작
//중복을 막기위해 domain을 뒤집어서 3레벨이상 작성하는 관행이 있다.
//한줄주석
/*
여러줄 주석
 */

/**
 *  <h1>javadoc 주석 </h1>
 *
 *  <pre>
 *  프로그램 문서에 기록될 주석 클래스/메소드/필드 등에 작성
 *  html 문법 지원
 *  </pre>
 */
public class Helloworld {

    /**
     * 메소드 - 자바코드를 실행하는 가장 작은 단위, 실행코드는 반드시 메소드 안에 위치해야함
     * main 메소드 - 자바프로그램의 시작. main메소드 안의 실행코드를 모두 처리하면 종료
     *  - public static void main(String[] args){}
     * @param args
     */
    public static void main(String[] args){
        System.out.println("안녕!");
    }

}
