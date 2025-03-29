package com.sh.operator.logical;

/**
 * <h3>논리연산자</h3>
 * <pre>
 *     - && (and) 좌우항이 모두 true인 경우 true를 반환
 *     - || (or) 좌항 또는 우항이 true인 경우 ture를 반환
 *     - ! 논리값을 반전해서 반환
 * </pre>
 *
 */
public class LogicalOperatorApp {
    public static void main(String[] args){
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);
        // -> 1 0 0 1

        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);
        // -> 1 1 1 0

        //논리 연산자 적용
        int a = 10, b = 20, c = 30, d = 40;
        System.out.println((a < b) && (c > d));             // 1 && 0 -> 0
        System.out.println(a == b && c > d);                // 0 && 0 -> 0
        System.out.println(a + b == c && d > 100);          // 1 && 0 -> 0
        System.out.println(a < b && ((b * c) > (d * d)));   // 1 && 0 -> 0

        System.out.println(a > b || c < d);                 // 0 || 1 -> 1
        System.out.println(a < b + 100 || c == d);          // 1 || 0 -> 1
        System.out.println(a != b || c > d * 2);            // 1 || 0 -> 1
        System.out.println(a + b + c > d || d > 0);         // 1 || 1 -> 1

        // 범위에 포함되는가 여부
        int x = 55;
        System.out.println(x > 1 && x < 100);
    }
}
