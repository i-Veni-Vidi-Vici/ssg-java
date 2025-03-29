package com.sh.operator.overflow;

/**
 * overflow
 * 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값을 순환 처리
 */
public class OverflowApp {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; //
        //i = i + 1;
        i = i + 2;
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j = j - 1;
        System.out.println(j); //
    }
}
