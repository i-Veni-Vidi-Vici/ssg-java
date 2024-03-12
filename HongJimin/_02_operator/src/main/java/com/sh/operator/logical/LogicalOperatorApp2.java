package com.sh.operator.logical;

/**
 * ⚠  and 연산자는 좌항이 false인 경우, 우항 검사 안함!
 *
 * - true && true → true
 * - true && false → false
 * - false && false → false (우항 검사 X)
 * - false && false → false (우항 검사 X)
 *
 * ⚠  or 연산자는 좌항이 true인 경우, 우항 검사 안함!
 *
 * - true | | false → true (우항 검사 X)
 * - true | | false → true (우항 검사 X)
 * - false | | true → true
 * - false | | false → false
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(false && num++ > 0); // 좌항이 false여서 우항 검사를 안함 그래서 num이 그대로 10으로 나옴!
        System.out.println(true && num++ > 0); //11
        System.out.println(num); //

        int k = 20;
        System.out.println(true || k++ > 20); // 좌항이 true여서 우항 검사를 안함~~
        System.out.println(false || k++ > 20); // k = 21
        System.out.println(k);
    }
}
