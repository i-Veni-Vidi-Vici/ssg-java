package com.sh.array.sort;

import java.util.Arrays;

/**
 * <pre>
 * - 변수의 값교환
 * - 배열요소의 값교환
 * </pre>
 */

public class Swap {

    public  static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @param arr
     * @param i 회차
     */
    public static void print(int[] arr, int i){
        // Arrays.toString(arr) : 배열의 내용 출력
        System.out.printf("%d : %s\n", i, Arrays.toString(arr));
    }

    public void test() {
        int a = 10;
        int b = 20;

        int temp = b; // b의 값 피신
        b = a;
        a = temp;

        System.out.println(a);
        System.out.println(b);

    }

    /**
     * 배열 요소 자리 교환
     */
    public void test2() {
        int[] arr = {1, 2, 4, 3, 5};
//        int temp = arr[2];
//        arr[2] = arr[3];
//        arr[3] = temp;

        swap(arr, 2, 3);

        for (int n : arr){
            System.out.print(n); // 1 2 3 4 5
        }
    }
}
