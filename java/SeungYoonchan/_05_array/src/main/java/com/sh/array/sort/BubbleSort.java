package com.sh.array.sort;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

public class BubbleSort {
    public void test1() {
        int[] arr = {5, 4, 1, 3, 2};

        // i = 4, 3, 2, 1
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
                print(arr,i);
            }


        }
    }
}
