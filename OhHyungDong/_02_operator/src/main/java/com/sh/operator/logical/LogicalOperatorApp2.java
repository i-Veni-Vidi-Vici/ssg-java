package com.sh.operator.logical;

/**
 * <pre>
 *
 *   논리연산자 진리표
 *
 *   - and 연산자는 좌항이 false인 경우 우항 검사를 하지 않는다 .
 *   - ture && true -> true
 *   - true &&false -> false
 *   - false && true -> false(우항 x)
 *   - true &&false -> false(우항  x)
 *
 *   -or 연산자는 좌항이 true인 경우 우항 검사를 하지 않는다.
 *  -  ture || true -> true (우항 X)
 *   - true || false -> true (우항 x)
 *   - false || true -> true
 *   - false || false -> false
 *
 *
 *
 *
 * </pre>
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(true && num ++ > 0); // 우항 검사함
       // System.out.println(false && num ++ > 0);
        System.out.println("num = " + num); // 10  : 앞에가 false기 떄문에 우항은 실행을 하지 않기 때문에


        int k = 20;
//        System.out.println(true || k++ > 20 );
        System.out.println(false || k++ > 20 ); // k=21
        System.out.println(k); //  20
    }
}
