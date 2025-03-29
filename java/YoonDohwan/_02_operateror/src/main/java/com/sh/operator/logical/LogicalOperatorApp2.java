package com.sh.operator.logical;
/*
논리연산자 진리표
and연산자는 좌항이 false인 경우 우항 검사를 하지 않는다.


true && true -> ture
true && false -> false
false && true -> false (우항 검사 안함)
false && false -> false (우항 검사 안함)

or 연산자는 좌항이 true인 경우 우항 검사를 하지 않는다.

true || true -> ture  (우항 검사안함)
true || false -> true (우항 검사안함)
true || true -> ture (우항 검사안함)
false || false -> false

 */
public class LogicalOperatorApp2 {
    public static void main(String[] args){
        int num=10;
        System.out.println(true||num++>0);
        System.out.println(num);
    }


}
