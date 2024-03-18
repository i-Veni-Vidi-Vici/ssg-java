package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;

/**
 * - 버블 정렬의 비교횟수가 많은 단점을 개선한 방식
 * - 정렬자리 수를 따로 temp 변수에 담아 두었다가 적절한 자리에 삽입
 */
public class InsertionSort {
    public void test() {
        int[] arr = {3, 2, 1,4,5};

        // i = 1, 2, 3, 4
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            int j;
            for (j = i; j > 0; j--) {
                // j-1 인덱스값이 temp보다 크다면 j-1인덱스의 값을 j인덱스에 덮어쓴다.
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    print(arr, i);
                }
                // j-1 인덱스값이 temp보다 작다면, 반복문 중지
                else {
                    print(arr, i);
                    break;
                }
            }
            arr[j]= temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
