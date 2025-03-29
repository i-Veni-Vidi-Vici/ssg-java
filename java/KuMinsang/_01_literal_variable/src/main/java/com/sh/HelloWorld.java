package com.sh;
// package 관련된 클래스 묶음. 디렉토리
// 실제 클래스의 이름은 패키지를 포함
// 실제 클래스의 이름은 com.sh.HelloWorld 이다
// 클래스와 패키지의 구분법 소문자=패키지(com.sh) 대문자=클래스(HelloWorld)
// 중복을 막기위해 pakage name은 domain을 뒤집어서 3레벨 이상 쓰는 경향이 있다.
// com.sh.Foo가 있을때 com.sh.Foo라는 파일을 추가할수 없다
// com.sh.Bar가 있을때 com.ssg.Bar는 패키지가 다르므로 생성 가능하다

// 한줄 주석
/*
    여러줄 주석
 */

/**
 * <h1>javadoc 주석</h1>
 * <pre>
 * - 프로그램 문서에 기록될 내용
 * - class/method/field 등에 작성
 * - html 문법 지원
 * </pre>
 */

public class HelloWorld {
    /**
     * 메소드 - 자바 코드를 실행하는 가장 작은 단위.
     * - 실행코드는 반드시 메소드 안에 위치해야함.
     * - main 메소드 : 자바프로그램의 시작점.
     *     main method 안의 실행코드를 모두 처리하면 종료
     * @param args
     */
    public static void main(String[] args){
        System.out.println("안녕");
    }
}
