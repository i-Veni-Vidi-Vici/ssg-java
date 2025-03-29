// package : 관련된 클래스 묶음
// 실제 클래스의 이름은 패키지를 포함.
// com.sh.HelloWorld가 풀네임.
// 중복을 막기위해 domain을 뒤집어서 3레벨 이상 작성하는 관행이 있다.
package com.sh;

// 한줄 주석 - 코드로써 해석되지 않고 무시됨.
/*
    여러줄 주석
 */

/**
 * <h3>javadoc 주석</h3>
 * <pre>
 *  - 프로그램 문서에 기록될 주석.
 *  - 클래스/메소드/필드 등에 작성.
 *  - html 문법 지원.
 * </pre>
 */
public class HelloWorld {
    /**
     * <h3>메소드</h3> 
     * <pre>
     * - 자바 코드를 실행하는 가장 작은 단위.
     * - 실행 코드는 반드시 메소드 안에 위치해야함.   
     * </pre>
     * <h3>main 메소드</h3>
     * <pre>
     * - 자바 프로그램의 시작.
     * - main 메소드 안의 실행 코드를 모두 처리하면 종료됨.
     * - "public static void main(String[] args){}" 를 정확히 작성해야 함.
     * </pre>
     * 
     * @param args
     */
    public static void main (String[] args){
        System.out.println("안녕.");
    }
}
