package com.sh.overflow;

/**
 * <pre>
 * overflow
 * - 자료형별로 표현 할 수 있는 최댓값을 벗어나면 다시 최소값으로 순환 처리되는 현상을 오버플로우라고 함.
 * - 최솟값을 벗어나면 다시 최댓값으로 순환됨 .
 * </pre>
 */
public class OverflowApp {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE; //2147483647

        System.out.println(i);
        i += 1;
        System.out.println(i);

        int m  =Integer.MIN_VALUE; //-2147483648
        m -= 1;
        System.out.println(m);
    }
}
