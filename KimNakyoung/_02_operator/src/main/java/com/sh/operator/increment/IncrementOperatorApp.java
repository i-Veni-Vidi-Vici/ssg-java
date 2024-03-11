package com.sh.operator.increment;

/**
 *
 * <pre>
 * 증감연산자
 * a++ 변수 a를 1증가시킨다.
 * a-- 변수 a를 1감소시킨다.
 *
 * 연산자 위치에 처리방식 달라진다.
 * - 전위 증감연산자 ++a --a 먼저 증감처리후 인접연산에 사용된다.
 * - 후위 증감연산자 a++ a-- 인접연산에 먼저 값을 사용한 후 증감처리 된다.
 *
 * </pre>
 *
 *
 */


public class IncrementOperatorApp {

    public static void main (String[] arg){
        //단항연산자 : 연산자에 항이 하나만 있다

        int a = 10;
        a++; // 1 증가
        a++; // 1 증가
        a++; // 1 증가
        System.out.println(a); // 1


        //전위 증감 연산자
        int m = 20;
////        System.out.println(++m); // 이때 인접연산은 출력이다.
//
//        int m2 = ++m + 2; // 이때 인접 연산은 +이다.
//        System.out.println("m = " + m +", m2=" + m2); // 21 23
        int m3 = ++m; // 이때 인접연산은 =이다.
        System.out.println("m = " + m +", m3 = " + m3); // 21,21

        int n = 30;
//        int n2 = n++ + 3; // 이때 인접 연산은 + 이다.
//        System.out.println("n =" + n +", n2 =" + n2); //31,33

        int n3 = n++; // 인접 연산 : 대입
        System.out.println("n = " + n + ", n3 = " + n3); // 31, 30

        int x = 20;
        int y = 50;
        int z = x++ + --y;
        System.out.println("x = " + x + ", y = "+ y + ", z = " + z); // 21 49 69

    }
}
