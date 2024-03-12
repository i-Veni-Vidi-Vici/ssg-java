package com.sh.overflow;

/**
 * <pre>
 *     overflow
 *     - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최솟값으로 순환 처리
 *     - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최솟값으로 순환 처리
 * </pre>
 */
public class OverflowApp {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; // 2_147_483_647
//        i = i + 1; // 2_147_483_647 + 1 = - 2_147_483_648, 최댓값인 2_147_483_647에 1을 더해서 최댓값을 넘었으므로
        i = i + 2; // 2_147_483_647 + 2 = - 2_147_483_647

        int j = Integer.MIN_VALUE;
        j = j - 1;
        System.out.println(j);
    }
}
