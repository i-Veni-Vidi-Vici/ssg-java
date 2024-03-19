package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * <pre>
 * 버블 정렬
 * - 인접한 두개의 요소를 검사해 정렬하는 방식
 * - 구현은 쉬우나, 정렬속도는 빠르지 않다.
 * - 이미 정렬된 데이터를 다시 정렬하는 경우 유용
 * - 바깥반복문은 인덱스가 아닌 반복횟수를 의미, 한회차에 오른쪽부터 정렬이 완성
 * </pre>
 */
public class BubbleSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};

        // i = 4, 3, 2,1 안쪽반복문의 반복횟수를 의미한다. (해당 인덱스의 적절한 수를 찾게됨, 우측부터)
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
                print(arr, i);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
