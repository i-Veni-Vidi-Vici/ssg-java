package com.sh.overflow;

/**
 * <pre>
 * overflow
 * - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값으로 순환 처리
 * - 자료형별로 표현할 수 있는 최소값을 벗어나면 다시 최대값으로 순환 처리
 * </pre>
 */

public class OverflowApp {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE; //2147483647
        System.out.println(maxValue);
        maxValue++; //-2147483648

        int j = Integer.MIN_VALUE;
        j--;
        System.out.println(j==Integer.MAX_VALUE);

    }
}
