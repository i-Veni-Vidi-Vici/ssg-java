package com.sh.overflow;

/**
 * <pre>
 *  overflow
 *  - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값으로 순환처리
 *  - 자료형별로 표현할 수 있는 최소값을 벗어나면 다시 최대값으로 순환처리
 *
 * </pre>
 */
public class OverflowApp {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        i = i + 2;
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j = j - 1; //+2147483647
        System.out.println(j);
    }
}
