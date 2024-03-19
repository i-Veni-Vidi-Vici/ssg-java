package com.sh.array.sort;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * <pre>
 *  순차정렬
 *  - 배열 정렬 알고리즘 중에 가장 기본
 *  - 회차에 해당하는 인덱스에 적절한 수를 찾는 방식
 *
 *
 * </pre>
 *
 */

public class SequencetialSort {
    public void test(){
        int[] arr = {5,4,1,3,2};
        // i = 0, 1, 2, 3
        // 5개중에 4개가 정답이면 나머지 하나는 알아서 정답이라 마지막 검사x
        for(int i = 0; i < arr.length - 1; i++){
            // i = 0, j = 1,2,3,4
            // i = 1, j = 2,3,4
            // i = 2, j = 3,4
            // i = 3, j = 4
            for(int j = i + 1; j < arr.length; j++){
                // 크기 비교(비교할 j번지수가 더 작다면, 값교환)
                if(arr[i] > arr[j]) {
                    swap(arr, i, j); // 왼쪽이 더 크면 자리 교환
                    print(arr, i);
                }
            }
        }
    }

}
