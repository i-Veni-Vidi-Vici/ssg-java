package com.sh.overflow;

public class OverflowApp {
    /**
     * <pre>
     * overflow
     * - 자료형별로 표현할 수 있는 최대값을 벗어 나면 다시 최소값으로 순환 처리하는 것
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; // 2_147_483_647
        i++; // Reassigned local variable
        System.out.println(i); // -2_147_483_648

        int j = Integer.MIN_VALUE; // -2_147_483_648
        j--; // Reassigned local variable
        System.out.println(j); // 2_147_483_647
    }
}
