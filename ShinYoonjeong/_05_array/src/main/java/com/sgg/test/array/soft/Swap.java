package com.sgg.test.array.soft;

import java.util.Arrays;

/**
 * - 변수의 값 교화
 * - 배열 요소의 값 교환
 */
public class Swap {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *
     * @param arr
     * @param i 회차
     */
    public static void print(int[] arr, int i)
    {
        // Arrays.toString(arr) : 배열의 내용 출력
        System.out.printf("%d : %s\n", i , Arrays.toString(arr));
    }
    public void test1(){
        int a = 10;
        int b = 20;
        int temp = b;
        b=a;
        a=temp;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 배열 요소 자리 교환
     */
    public void test2(){
        int[] arr = {1,2,3,4,5};
        //arr[3] = arr[2];
        //arr[2] = arr[3];
        int[] ar = new int[1];
        ar[0] = arr[3];
        arr[3] = arr[2];
        arr[2] = ar[0];
        for(int n: arr)
            System.out.println(n);
    }
}
