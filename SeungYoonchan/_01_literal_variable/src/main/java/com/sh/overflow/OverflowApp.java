package com.sh.overflow;

/**
 * <h3>Overflow</h3>
 * <pre>
 *     - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값을 순환 처리
 * </pre>
 */
public class OverflowApp {
    public static void main(String[] args){
        int i = Integer.MAX_VALUE; // 2_147_483_647
        //i = i + 1; // 2+147_483_647 + 1 = -2_147_483_648;

        int j = Integer.MIN_VALUE;
        j = j -1; // -2_147_483_648 - 1 = 2_147_483_647
        System.out.println(j); // 2_147_483_647
    }
}
