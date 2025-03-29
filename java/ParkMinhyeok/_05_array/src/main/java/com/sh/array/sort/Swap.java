package com.sh.array.sort;

import java.util.Arrays;

public class Swap {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *
     * @param arr
     * @param i 회차
     */
    public static void print(int[] arr, int i) {
        System.out.printf("%d : %s\n", i, Arrays.toString(arr));
    }
    public void test1() {
        int a = 10;
        int b = 20;
        int temp = b;

        b = a;
        a = temp;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 배열 요소 자리 교환
     */
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
//        int temp = arr[3];
//        arr[3] = arr[2];
//        arr[2] = temp;
        swap(arr, 2, 3);
        System.out.print(Arrays.toString(arr));
    }
}
