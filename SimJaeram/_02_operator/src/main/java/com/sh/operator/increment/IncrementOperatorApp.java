package com.sh.operator.increment;

/**
 * <pre>
 *     증감 연산자
 *     a++ // 변수 a를 1 증가시킨다.
 *     a-- // 변수 a를 1 감소시킨다.
 *
 *     증감 연산자의 위치에 따라 처리 순서가 달라진다. (연산자의 위치기준 전,후위)
 *     - 전위 증감연산자 ++a --a 먼저 증감 처리 후 인접연산에 사용된다.
 *     - 후위 증감연산자 a++ a-- 인접연산에 먼저 사용한 후 증감 처리한다.
 * </pre>
 */

public class IncrementOperatorApp {
    public static void main(String[] args) {
        // 단항 연산자
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
//        int m2 = ++m + 2;
//        System.out.println("m = "+ m + ", m2= " + m2);
        int m3 = ++m; // 먼저 m에 +1 되므로 m은 21, m3에 m 대입연산
        System.out.println("m = " + m + ", m3 = " + m3); //


        // 후위 증감 연산자
        int n = 30;
//        System.out.println(n++); // 30, 먼저 n이 출력된 후, +1이 된다.
//        System.out.println(n); // 31
//        int n2 = n++ + 3;
//        System.out.println("n = " + n + ", n2 = " + n2);
        int n3 = n++; // 전위 증감연산자, n을 n3에 먼저 대입연산 후 n에 +1, n3는 30, n은 31
        System.out.println("n = " + n + ", n3 = " + n3);

        int x = 40;
        int y = 50;
        int z = x++ + --y; // x는 전위 연산자, y는 후위 연산자이므로 40 + 49 == 89를 z에 대입연산, x는 41, y는 49
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
    }
}
