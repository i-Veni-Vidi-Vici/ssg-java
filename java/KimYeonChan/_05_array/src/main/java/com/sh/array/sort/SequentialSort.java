package com.sh.array.sort;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * 순차 정렬
 * - 배열 정렬 알고리즘 중에 가장 기본
 * - 회차에 해당하는 인덱스에 적절한 수를 찾는 방식
 */
public class SequentialSort {
    public void test1() {
        int[] arr = {5, 4, 1, 3, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // 크기 비교(비교할 j 번지수가 더 작다면, 값 교환)
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
                print(arr, i);
            }
        }
    }
}
