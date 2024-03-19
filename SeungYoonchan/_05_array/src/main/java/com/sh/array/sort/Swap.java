package com.sh.array.sort;


import java.util.Arrays;

/**
 * <pre>
 *     - 변수의 값 교환
 *     - 배열 요소의 값 교환
 * </pre>
 */
public class Swap {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @param arr
     * @param i - 회차
     */
    public static void print(int[] arr, int i){
        //Arrays.toString(arr) : 배열의 내용 출력
        System.out.printf("%d : %s\n", i, Arrays.toString(arr));
    }
}
