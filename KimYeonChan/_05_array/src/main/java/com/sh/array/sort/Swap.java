package com.sh.array.sort;

import java.util.Arrays;

/**
 * 변수의 값 교환
 * 배열요소의 값 교환
 */
public class Swap {
    public static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr, int i) {
        System.out.printf("%d: %s\n", i, Arrays.toString(arr));
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

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
