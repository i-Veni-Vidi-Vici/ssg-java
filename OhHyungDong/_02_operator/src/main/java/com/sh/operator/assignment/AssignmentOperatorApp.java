package com.sh.operator.assignment;

/**
 * <pre>
 *  대입 연산자(=)
 *  - 좌항의 변수(공간)에 우항의 값을 대입
 *  - 우항에 다른 변수를 사용한다해도, 값으로써 처리한다.
 *
 *  복합대입, 산술연산자
 *  +=
 *  -=
 *  *=
 *  /=
 *  %=
 *
 * </pre>
 */
public class AssignmentOperatorApp {

    public static void main(String[] args) {
        //복합 대입 연산자 (순서에 유의 할 것)
        int num = 10;
        num += 3;
        System.out.println("num = " + num);
        
        num -=3;
        System.out.println("num = " + num);
        
        num *= 3;
        System.out.println("num = " + num);
        
        num /= 3;
        System.out.println("num = " + num);
        
        num %= 3;
        System.out.println("num = " + num);
    }
}
