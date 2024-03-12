package com.sh.operator.logical;

/**
 *<pre>
 * 논리연산자 진리표
 * -true && flase -> true
 * - true && ture -> false
 * - false && true -> false (우항 검사 안함)
 * - false && false -> fa;se (우항 검사 안함)
 *
 * - or연산자는 좌항이 true인 경우 우항 검사를 하지 않는다.
 * -true || true -> true(우항 검사 안함)
 * - true || false -> true(우항 검사 안함)
 * -false || true -> true
 * - false || flase -> false
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args){
        int num=10;
//      System.out.println(true && num++ > 0) //11
        System.out.println(false && num++ > 0); // 우항검사 안함 10
        System.out.println(num);

        int k=20;
//      System.out.println(true || k++ >20); // 우항 검사 안함 20
        System.out.println(k);
    }
}

