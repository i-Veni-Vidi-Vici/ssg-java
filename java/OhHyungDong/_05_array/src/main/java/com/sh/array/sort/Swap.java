package com.sh.array.sort;

import java.util.Arrays;

/**
 * <pre>
 *
 * 1.변수의 값 교환
 * 2.배열 요소의 값 교환
 * </pre>
 */
public class Swap {

    public static void swap(int[] arr,int i ,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    /**
     * @param arr
     * @param i 회차
     */

    public static void print(int[] arr, int i)
    {
        //Arrays.toString(arr) : 배열의 내용 출력
        System.out.printf("%d : %s \n", i, Arrays.toString(arr));
    }
    public void test1()
    {
        int a = 10;
        int b = 20;

        int temp = a ;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }

    //배열 요소 자리 교환
    public void test2()
    {
        int[] arr = {1,2,3,4,5};

//        int temp = arr[3];
//       arr[3] = arr[2];
//       arr[2]= temp;
        swap(arr,2,3);

    }



}
