package com.sh.overflow;

public class OverflowApp {

    /**
     * <pre>
     * overflow
     * - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값으로 순환 처리
     * - 자료형별로 표현할 수 있는 최소값을 벗어나면 다시 최대값으로 순환 처리
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        i += 1;
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j -= 1;
        System.out.println(j);          // 정수 최대값


    }
}
