package com.sh.operator.logical;

/**
 * 논리 연산자 진리표
 *
 */

public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
        //System.out.println(true && num++ > 0); //true , a = 11 출력
        System.out.println(false && num++ > 0); //우항을 실행하지 않음 a = 10 출력
        System.out.println(num); //11 또는 10

        int k = 20;
        System.out.println(true || ++k > 20); //우항 검사를 하지 않음 true a = 20
        //System.out.println(false|| k++ > 20);   //우항을 실행함 false 21
        System.out.println(k);
    }
}
