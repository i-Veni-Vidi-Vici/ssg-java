package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * <pre>
 *     선택정렬
 *     - 각 회차에 최소값을 찾고, 회차 마지막에 1번만 값 교환하는 방식
 *     - 순차정렬 대비 성능이 우수하다. (교환회수가 적음)
 * </pre>
 */

public class SelectionSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};

        // i = 0, 1, 2, 3 (마지막 인덱스는 비교하지 않음.)
        for(int i = 0; i < arr.length- 1; i++) {
            // 최소값을 가리키는 인덱스. 최초에는 i번지라고 설정
            int min = i;
            // i = 0, j = 1, 2, 3, 4
            // i = 1, j = 2, 3, 4
            // i = 2, j = 3, 4
            // i = 3, j = 4
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[min] > arr[j])
                    min = j;            // 이제 최소값은 j번지

                print(arr, i);
            }
            swap(arr, i, min);
        }
        System.out.println(Arrays.toString(arr));
    }
}
