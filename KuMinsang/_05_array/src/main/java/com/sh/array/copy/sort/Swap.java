package com.sh.array.copy.sort;

import java.util.Arrays;

/**
 * <pre>
 *     -변수의 값 교환
 *     -배열 요소의 값 교환
 * </pre>
 */
public class Swap {
    public void test1(){
        int a= 10;
        int b = 20;

        b=a;
        a=b;

        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 배열요소 자리교환
     */
    public void test2(){
        int[] arr = {1,2,3,4,5};
        arr[3] = arr[2];
        arr[2] = arr[3];

        for(int n : arr)
            System.out.println(n);

    }
    public static void swap (int[] arr, int index1 ,int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
        /*
        System.out.println(">swap : "+ arr[index1]);
        System.out.println(">swap : "+ arr[index2]);
        */

    }

    public static void print(int[] arr, int i){
        //Arrays.toString(arr) : 배열의 내용 출력
        System.out.printf("%d : %s\n ", i , Arrays.toString(arr));
    }
}
