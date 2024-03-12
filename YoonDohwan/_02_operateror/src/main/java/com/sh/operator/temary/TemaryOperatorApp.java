package com.sh.operator.temary;
/*
삼항 연산자
조건식 ? 참일때 값 : 거짓일때 값
조건식에는 논리값 또는 논리값을 반환하는 연산식을 작성해야 한다.
 */
public class TemaryOperatorApp {
    public static void main(String[] args){

        int a = 30;
        int b = 20;
        System.out.println("a는 b보다" + (a>b ? "크다" : "작다"));
        int x = 0;
        System.out.println("x는"+(x>0?"양수다":(x==0?"0이다":"음수다")));
        int k=20;
        int m=35;
        int max=(k>m? k:m);
        System.out.println(max);

    }
}
