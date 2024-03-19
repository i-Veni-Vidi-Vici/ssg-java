package com.sh.array.sort;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * 선택정렬
 * - 각 회차에 최소값을 찾고, 회차 마지막에 1번만 교환하는 방식
 * - 순차정렬 대비 성능 우수 (교환회수가 적음)
 */
public class SelectionSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};
        // 최소값을 가리키는 인덱스
        // i = 0, 1, 2, 3 (마지막 자리는 비교하지 않음.)
        for (int i = 0; i < arr.length; i++) {
            // 최소값을 가리키는 인덱스. 최초 i번지라고 설정
            int min =i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j; // 이제 최소값은 j번지
                }

                print(arr, i);
            }
            swap(arr, i, min);
        }
    }
}
