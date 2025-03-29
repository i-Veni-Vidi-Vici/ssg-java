package com.sh.array.sort;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

public class SequentialSort {
    public void test1(){
        int[] arr = {5, 4, 1, 3, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr,i,j);
                }
            }
            print(arr,i);
        }
    }
}
