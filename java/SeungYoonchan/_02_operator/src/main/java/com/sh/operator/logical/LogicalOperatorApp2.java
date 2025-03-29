package com.sh.operator.logical;

/**
 * <h3>논리 연산자 진리표</h3>
 * <pre>
 *     - and 연산자는 좌항이 false인 경우 우항 검사를 하지 않는다.
 *     1 && 1
 *     1 && 0
 *     0 && 1   우항 검사 x
 *     0 && 0   우항 검사 x
 *
 *     - or 연산자는 좌항이 true인 경우 우항 검사를 하지 않는다.
 *     1 || 1   우항 검사 x
 *     1 || 0   우항 검사 x
 *     0 || 1
 *     0 || 0
 * </pre>
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args){
        int num = 10;
        System.out.println(true && num++ > 0); // 11
        System.out.println(false && num++ > 0); // 우항 검사 x | num == 10
        System.out.println(num); //10

        int k = 20;
        System.out.println(true || k++ > 20); // 우항 검사 안함 | k == 20
        System.out.println(true || k++ > 20); // k == 21
        System.out.println(k); //21
    }
}
