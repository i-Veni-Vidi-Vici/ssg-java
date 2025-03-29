package com.sh.operator.logical;

/**
 * <pre>
 *     논리연산자
 *     - && (and) 좌항과 우항이 모두 true인 경우 true를 반환
 *     - || (or) 좌항 또는 우항이 true인 경우 true를 반환
 *
 *     논리부정연산자
 *     - ! 논리값을 반전해서 반환
 * </pre>
 */

public class LogicalOperatorApp {
    public static void main(String[] args) {

        // 논리연산자
        // && - 모두 true여야 true
        System.out.println(true && true);       // true
        System.out.println(true && false);      // false
        System.out.println(false && true);      // false
        System.out.println(false && false);     // false

        // || - 둘중 하나만 true여도 true
        System.out.println(true || true);       // true
        System.out.println(true || false);      // true
        System.out.println(false || true);      // true
        System.out.println(false || false);     // false
        System.out.println();

        // 논리연산자 적용
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;

        System.out.println((a < b) && (c < d));     // a가 b보다 작으면서0(true) c가 d보다 작으면(true), true
        System.out.println(a == b && c > d);        // a와 b가 같으면서(false) c가 d보다 큰지(false), false
        System.out.println(a + b == c && d > 100);  // a + b가 c와 같으면서(true) d가 100보다 큰지(false), false
        System.out.println(a < b && b * c > d * d); // a가 b보다 작으면서(true) b와 c의 곱이 d의 제곱보다 큰지(false), false
        System.out.println();

        System.out.println(a > b || c < d);         // a가 b보다 크거나(false) c가 d보다 작은지(true), true
        System.out.println(a < b + 100 || c == d);  // a가 b + 100보다 작거나(true) c와 d가 동일한지(false), true
        System.out.println(a != b || c > d * 2);    // a와 b가 다르거나(true) c가 d * 2보다 큰지(false), true
        System.out.println(a + b + c > d || d > 0); // a + b + c가 d보다 크거나(true) d가 양수인지(true), true
        System.out.println();

        // 범위에 포함되는가 여부
        int x = 55;
        System.out.println((1 < x) && (x < 100));   // x가 1에서 100사이 숫자인가 -> x가 1보다 크면서(true) x가 100보다 작은지(true), true
        System.out.println(1 <= x && 100 >= x);     // 가능하지만, 관례적인 방식으로 작성하자
    }
}
