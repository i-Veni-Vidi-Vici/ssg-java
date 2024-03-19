package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * 선택정렬
 * - 각 회차에 최소값을 찾고, 회차 마지막에 한번만 값교환 하는 방식
 * - 순차정렬 대비 성능이 우수(교환 횟수가 적음)
 */

public class SelectionSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};
        // i = 0,1,2,3 (마지막 자리는 비교X)
        for (int i = 0; i < arr.length; i++){
            // 최소값을 가리키는 인덱스, 최초 i번지라고 설정
            int min = i;
            // i=0, j=1,2,3,4
            // i=1, j=2,3,4
            // i=2, j=3,4
            // i=3, j=4
            for (int j = i + 1; j < arr.length; j++){
                if (arr[min] > arr[j]){
                    min = j; // 이제 최소값은 j번지
                }
                print(arr, i); // 값은 아직 안바뀌어서 큰 의미X (계속 최소값만 찾는중)
            }
            swap(arr, i, min); // inner for문 끝난 후 값 바꾸기
        }
        System.out.println(Arrays.toString(arr));
    }
}
