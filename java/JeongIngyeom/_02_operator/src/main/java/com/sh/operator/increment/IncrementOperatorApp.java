package com.sh.operator.increment;

public class IncrementOperatorApp {

    /**
     * <pre>
     * 증감 연산자
     * a++ 변수 a를 1 증가시킨다.
     * a-- 변수 a를 1 감소시킨다.
     *
     * 연산자 위치에 따라 처리방식이 달라진다.
     * - 전위 증감연산자 ++a --a 먼저 증감 처리 후 인접 연산에 사용된다.
     * - 후위 증감연산자 a++ a-- 인접 연산에 먼저 값을 사용한 후 증감 처리한다.
     * </pre>
     * @param args
     */
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
        System.out.println(++m);            // 21
        int m2 = ++m + 2;
        System.out.println(m + " " + m2);   // 22 24
        int m3 = ++m;
        System.out.println(m + " " + m3);   // 23 23

        // 후위 증감 연산자
        int n = 30;
        System.out.println(n++);            // 30
        System.out.println(n);              // 31
        int n2 = n++ + 3;
        System.out.println(n + " " + n2);   // 32 34
        int n3 = n++;
        System.out.println(n + " " + n3);   // 33 32

        int x = 40;
        int y = 50;
        int z = x++ + --y;
        System.out.println(x + " " + y + " " + z);  // 41 49 89
    }
}
