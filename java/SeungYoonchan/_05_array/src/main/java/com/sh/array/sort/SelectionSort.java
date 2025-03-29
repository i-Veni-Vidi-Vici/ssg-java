package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

public class SelectionSort {
    public void test1() {
        int[] arr = {5, 4, 1, 3, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
                print(arr,i);
            }
            swap(arr,i,min);
        }

        System.out.println(Arrays.toString(arr));
    }
}
