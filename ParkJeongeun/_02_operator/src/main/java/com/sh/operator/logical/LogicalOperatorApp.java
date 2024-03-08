package com.sh.operator.logical;

/**
 * <pre>
 * 논리 연산자
 * - && (and) 좌우항이 모두 true인 경우 true를 반환
 * - || (or) 좌항 또는 우항이 true인 경우 true 반환
 *
 * 논리 부정연산자
 * - ! 논리값을 반전해서 반환
 * </pre>
 */

public class LogicalOperatorApp {
    public static void main(String[] args) {
        // 논리 연산자
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        // 논리 연산자 적용
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        System.out.println(a < b && c > d);
        System.out.println(a == b && c > d);
        System.out.println((a + b) == c && d > 100);
        System.out.println(a < b && (b * c) > d * d);

        System.out.println(a > b || c < d);
        System.out.println(a < (b + 100) || c == d);
        System.out.println(a != b || c > (d * 2));
        System.out.println((a + b + c) > d || d > 0);

        // 범위에 포함되는가 여부
        int x = 55;
        System.out.println(x >= 1 && x <= 100); // x가 1에서 100사이 숫자인가

    }
}
