package com.sh.overflow;

/**
 * <pre>
 * overflow
 *  - 자료형별로 표현 할 수 있는 최대값을 벗어나면 다시 최소값으로 순환 처리
 *  - 자료형별로 표현 할 수 있는 최소값을 벗어나면 다시 최대값으로 순환 처리
 * </pre>
 */
public class OverflowApp {
    public static void main(String[] args){
        int a=Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(a+1);
        System.out.println(a=Integer.MIN_VALUE-1);
    }
}
