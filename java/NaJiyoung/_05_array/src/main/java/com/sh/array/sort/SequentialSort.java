package com.sh.array.sort;

import java.util.Arrays;
import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * <pre>
 * 순차정렬
 * - 배열 정렬 알고리즘 중에 가장 기본.
 * - 회차에 해당하는 인덱스에 적절한 수를 찾는 방식
 * </pre>
 */
public class SequentialSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};

        System.out.println("전 : " + Arrays.toString(arr));
        // i = 0, 1, 2, 3 회차(배열 인덱스)
        for(int i = 0; i < arr.length - 1; i++) {
            // i = 0, j = 1, 2, 3, 4
            // i = 1, j = 2, 3, 4
            // i = 2, j = 3, 4
            // i = 3, j = 4
            for(int j = i + 1; j < arr.length; j++) {
                // 크기 비교 (비교할 j번지수가 더 작다면, 값교환)
                if(arr[i] > arr[j])
                    swap(arr, i, j);
                print(arr, i);
            }
        }
        System.out.println("후 : " + Arrays.toString(arr));
    }
}