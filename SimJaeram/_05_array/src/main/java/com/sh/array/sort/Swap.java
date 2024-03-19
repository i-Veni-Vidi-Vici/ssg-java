package com.sh.array.sort;

import java.util.Arrays;

/**
 * <pre>
 *     - 변수의 값 교환
 *     - 배열 요소의 값 교환
 * </pre>
 */
public class Swap {
    /**
     *
     * @param arr
     * @param i 회차
     */
    public static void print(int[] arr, int i) {
        // Arrays.toString(arr) : 배열의 내용 출력
        System.out.printf("%d : %s\n", i, Arrays.toString(arr));
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void test1() {
        // 변수 선언 및 초기화
        int a = 10;
        int b = 20;

        int temp = b; // 피신
        b = a;
        a = temp;

        // 출력
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * <pre>
     *     배열 요소 자리교환
     * </pre>
     */
    public void test2() {
        int[] arr = {1, 2, 4, 3, 5};

//        int temp = arr[3];
//        arr[3] = arr[2];
//        arr[2] = temp;

        swap(arr, 2, 3);

        for(int n : arr)
            System.out.println(n);
    }

}
