package com.sh.math;

/**
 * <pre>
 * API
 * - Application Programming Interface
 * - 운영체제/프로그래밍 언어등이 제공하는 기능을 제어할 수 있도록 제공하는 인터페이스(규격)
 * - 미리 만들어진 기능들을 가져다 쓰는 방법
 *
 * Math API
 * - 수학관련 자주 사용하는 상수 혹은 기능들을 작성해둔 클래스
 * - 모든 메소는 static으로 구성되어 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args)
    {
        //1. 절대값
        System.out.println(Math.abs(-7));// int반환
        System.out.println(Math.abs(7));
        System.out.println(Math.abs(7.3));// double 반환

        //2. 최대/최소값
        System.out.println(Math.max(10,20));
        System.out.println(Math.max(20,10));
        System.out.println(Math.min(20,10));

        //3. 난수생성
        System.out.println(Math.random()*10);//0.0~1.0미만의 난수 반환

        //4. Math관련 상수 제공
        System.out.println(Math.PI);//상수 = final = 최초로 입력 후 변경 불가

    }
}
