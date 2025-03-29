package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;

public class InsertionSort {
    public void test1(){
        int[] arr = {5, 4, 1, 3, 2};

        int temp, i, j;
        for (i = 1; i < arr.length; i++) {

            temp = arr[i];
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    print(arr, i);
                } else {
                    print(arr, i);
                    break;
                }
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
