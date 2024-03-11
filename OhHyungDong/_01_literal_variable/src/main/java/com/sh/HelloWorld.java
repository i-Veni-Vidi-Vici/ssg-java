package com.sh;
// 클래스 묶음.
// 실제 클래스의 이름은 패키지를 포함. -> com.sh.HelloWorld
// 중복을 막기 위해 domain을 뒤집어 3레벨 이상 쓰는 관행이 있다.

/**
 * - <h1>Javadoc 주석</h1>:
 * <pre>
 * - 프로그램 문서에 기록될 주석
 * - 클래스/메소드/필드 등에 작성.
 * - HTML문법도 지원을 함.
* </pre> : 줄바꿈 처리 도와줌.
 */
public class HelloWorld
{
    /**
     * 메소드 - 자바 코드를 실행하는 가장 작은 단위, 실행 코드는 메소드 안에 위치
     * main 메소드 - 자바 프로그램의 시작 -> 실행 문장이 없으면 자바 종료
     * @param args
     */

    public static void main(String[] args)
        {
            System.out.println("하이욖");
        }
}
