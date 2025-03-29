package com.sh.array.sort;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * 변수의 값교환
 * 배열요소의 값교환
 */
public class Swap {
    public void test1() {
        int a = 10;
        int b = 20;
        int temp = b;
        b = a;
        a = temp;

        System.out.println(a);
        System.out.println(b);

    }

    public void test2() {
        /**
         * 배열요소 자리 교환
         */
        int[] arr = {1, 2, 4, 3, 5};
        int temp = arr[3];
        arr[3] = arr[2];
        arr[2] = temp;
        for (int n : arr)
            System.out.println(n);

    }

    public class swap {
        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

    /**
     *
     * @param arr
     * @param i회차
     */
    public static void print(int[] arr,int i){
        //Arrays.toString(arr):배열의 내용출력
        System.out.printf("%d : %s\n",i, Arrays.toString(arr));
    }
}