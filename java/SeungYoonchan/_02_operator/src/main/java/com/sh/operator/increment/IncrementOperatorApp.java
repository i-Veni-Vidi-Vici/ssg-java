package com.sh.operator.increment;

/**
 * <h3>증감 연산자</h3>
 * <pre>
 * a++ 변수 a를 1 증가시킨다.
 * a-- 변수 a를 1 감소시킨다.
 *
 * 연산자 위치에 처리방식 달라진다.
 * - 전위 증감연산자 ++a --a 먼저 증감처리 후 인접연산에 사용된다.
 * - 후위 증감연산자 a++ a-- 인접 연산에 먼저 값을 사용한 후 증감처리 한다.
 *
 * </pre>
 */

public class IncrementOperatorApp {
    public static void main(String[] args) {

        // 단항연산자
        int a = 10;
        a++;
        a++;
        a++;
        System.out.println(a);
        a--;
        System.out.println(a);

        // 전위 증감 연산자
        int m = 20;
//        System.out.println(++m); // 이때 인접연산은 출력이다.
        int m2 =  ++m + 2;
//        System.out.println("m = " + m + ", m2 = " + m2); //m = 21, m2 = 23
        int m3 = ++m;
        System.out.println("m = " + m + ", m3 = " + m3); //m = 21, m3 = 21

        // 후위 증감 연산자
        int n = 30;
//        System.out.println(n++);
//        System.out.println(n);
//        int n2 = n++ + 3;
//        System.out.println("n = " + n + ", n2 = " + n2); //n = 31, n2 = 33
        int n3 = n++;
        System.out.println("n = " + n + ", n3 = " + n3); //n = 31, n3 = 30

        int x = 40;
        int y = 50;
        int z = x++ + --y; //40 + 49
        System.out.println("x = " + x + ", y = " + y + ", z = " + z); //x = 41, y = 49, z = 89
    }
}