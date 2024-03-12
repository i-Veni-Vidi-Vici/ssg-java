package com.sh.overflow;

/**
 * <pre>
 * overflow
 * - 자료형별로 표현할 수 있는 최댓값/최솟값을 벗어나면 다시 최솟값/최댓값을 순환 처리
 * </pre>
 */

public class OverflowApp {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; // 2147483647
        i = i + 1; // -2147483648 최솟값으로 순환
        i = i + 2;
        System.out.println(i);
        int j = Integer.MIN_VALUE; // -2147483648
        j = j - 1; // 2147483647
        System.out.println(j);
    }
}
