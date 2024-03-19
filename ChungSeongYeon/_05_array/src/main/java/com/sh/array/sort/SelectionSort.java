package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * 선택 정렬
 * - 각 회차에 최소값을 찾고, 회차 마지막에 1번만 값 교환하는 방식
 * - 순차 정렬 대비 성능이 우수. (교환 횟수가 적음)
 */

public class SelectionSort {
    public void test1() {
        int[] arr = {5, 4, 1, 3, 2};

        // i = 0, 1, 2, 3 (마지막 자리 비교 X.)
        for(int i = 0; i < arr.length - 1; i++){

            // 최소값을 가리키는 인덱스. 최초 i번지라고 설정.
            int min = i;
            // i = 0, j = 1, 2, 3, 4
            // i = 1, j = 2, 3, 4
            // i = 2, j = 3, 4
            // i = 3, j = 4
            for(int j = i + 1; j < arr.length; j++){
                if(arr[min] > arr[j]) //arr[min] < arr[j] -> 내림차순
                    min = j; // 이제 최소 값은 j번지
                print(arr, i);
            }
            swap(arr, i, min);
        }

        System.out.println(Arrays.toString(arr));

    }

}
