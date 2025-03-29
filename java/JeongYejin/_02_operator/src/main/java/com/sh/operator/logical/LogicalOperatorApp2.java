package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산자 진리표
 * ! and 연산자는 좌항이 false인 경우 우항 검사를 하지 않는다
 *
 * - true && true -> true
 * - true && false -> false
 * - false && true -> false (우항 검사 안함)
 * - false && false -> false (우항 검사 안함)
 *
 * ! or 연산자는 좌항이 true인 경우 우항 검사를 하지 않는다
 * - true || true -> true
 * - true || false -> true
 * - false || true -> true
 * - false || false -> false
 * </pre>
 */

public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(false && num++ > 0); // && 일 때 좌항이 false이니까 우항을 검사하지 않아서 num은 증가하지 않고 그대로 10이다.
//        System.out.println(true && num++ > 0); // && 일 때 좌항이 true면 우항을 검사하기 때문에 num은 증가하여 11이다.
        System.out.println(num);

        int k = 20;
        System.out.println(true || k++ > 20); // || 일 때 좌항이 true니까 우항을 검사하지 않아서 num은 증가하지 않고 그대로 20이다.
        System.out.println(k);
    }
}
