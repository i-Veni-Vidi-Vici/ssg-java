package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산사 진리표
 *
 * 좌항이 false면 우항 검사 안함
 * - true && true -> true
 * - true && false -> false
 * - false && true -> false // 우항검사 안함
 * - false && false -> false // 우항검사 안함
 *
 * 좌항이 ture일 때 검사 안한ㅁ
 * - true || true -> true // 우함검사 안함
 * - true || false -> true // 우함검사 안함
 * - false || true -> true
 * - false || false -> false
 * </pre>
 */

public class LogicalOperatorApp2 {
    public static void main(String[] args){
        int num=10;
        System.out.println(false && num++ > 0);//우함 검사 안함
        System.out.println(num);
        //true, num=11  false,num=10

        int k=20;
        System.out.println(true && k++>20);// 우함까지 검사 함
        System.out.println(k);
    }
}
