package com.sh.overflow;

/**
 * overflow
 * - 자료형 별로 표현할 수 있는 최댓값을 벗어나면 다시 최솟값으로 순환되는 처리
 */

public class OverflowApp {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; //2_147_483_647
        i += 1; // - 2_147_483_648
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j = j - 1;
        System.out.println(j); //2_147_483_647

    }
}
