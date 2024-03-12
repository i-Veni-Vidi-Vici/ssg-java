package com.sh.overflow;

/**
 * <pre>
 * overflow
 * - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최소값을 순환 처리
 * - 자료형별로 표현할 수 있는 최대값을 벗어나면 다시 최대값을 순환 처리
 * </pre>
 *
 */



public class OverflowApp {
    public static void main(String[] args){
        int i = Integer.MAX_VALUE; // 2_147_483_647
//        i = i + 1; // 2_147_483_647 + 1 = -2_147_483_647 (더이상 위로 못가면 최솟값으로 순환) 첫번째 예시
        i = i + 2;
        System.out.println(i);

        int j = Integer.MIN_VALUE;
        j = j - 1 ;
        System.out.println(j); // 2_147_483_647 더이상 밑으로 못가면 최대값 두번째 예시

    }
}
