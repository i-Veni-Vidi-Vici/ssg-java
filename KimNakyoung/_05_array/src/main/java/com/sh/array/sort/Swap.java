package com.sh.array.sort;

import java.util.Arrays;

/**
 * <pre>
 * - 변수의 값교환
 * - 배열요소의 값교환
 * </pre>
 *
 *
 */


public class Swap {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void test1(){
        int a = 10;
        int b = 20;

        int temp = 0;
        temp = a;
        a = b ;
        b = temp;

        System.out.println(a);
        System.out.println(b);
    }


    /**
     *
     * @param arr
     * @param i
     */
    public static void print(int[] arr, int i){
        System.out.printf("%d : %s\n" , i, Arrays.toString(arr));
    }

    public void test2(){
        int[] arr = {1,2,4,3,5};
//        int temp = arr[3]; // 지워지기 전에  temp의 값 넣기
//        arr[3] = arr[2];
//        arr[2] = temp;

        swap(arr,2,3);
        for(int n : arr)
            System.out.println(n);
    }

}
