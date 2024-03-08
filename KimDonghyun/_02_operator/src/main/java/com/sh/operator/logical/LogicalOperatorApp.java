package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산자
 * - && (and) 좌우항이 모두 true인 경우 true를 반환
 * - || (or) 좌항 또는 우항이 true인 경우 true를 반환
 * 
 * 논리부정연산자 
 * - ! 논리값을 반전해서 반환
 * </pre>
 */
public class LogicalOperatorApp {
    public static void main(String[] args) {
        // 논리연산자
        System.out.println(true && true); // true
        System.out.println(true && false); // false
        System.out.println(false && true); // false
        System.out.println(false && false); // false

        System.out.println(true || true); // true
        System.out.println(true || false); // true
        System.out.println(false || true); // true
        System.out.println(false || false); // false

        // 논리 연산자 적용
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        System.out.println((a < b) && (c < d)); // a가 b보다 작으면서  c가 d보다 작은지 여부
        System.out.println(a == b && c > d); // a와 b가 같으면서 c가 d보다 큰 지 여부
        System.out.println(a + b == c && d > 100); // a + b가  c와 같으면서 d가  100보다 큰 지 여부
        System.out.println(a < b && b * c > d * d); // a 가 b 보다 작으면서  b와 c의 곱이 d의 제곱보다 큰 지 여부

        System.out.println(a > b || c < d); // a가 b보다 크거나 c가 d보다 작은지 여부
        System.out.println(a < b + 100 || c == d); // a가 b + 100보다 작거나 c와 d가 동일한 지 여부
        System.out.println(a != b || c > d * 2); // a와 b가 다르거나 c가 d * 2보다  큰지 여부
        System.out.println(a + b + c < d || d == 0); // a + b + c가 d보다 작거나 d가 음수인지 여부

        // 범위에 포함되는가 여부
        int x = 55;
        System.out.println(x >= 1 && x <= 100); // x가 1에서 100사이 숫자인가 여부 -> x가 1이상이면서 x가 100이하인가 여부
        System.out.println(1 <= x && 100 >= x); // 가능하지만, 관례상 변수를 왼쪽에 사용하자.
    }
}
