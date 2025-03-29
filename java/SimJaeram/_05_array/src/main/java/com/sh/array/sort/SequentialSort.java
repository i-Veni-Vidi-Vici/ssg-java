package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * <pre>
 *     순차정렬
 *     - 배열 정렬 알고리즘 중에 가장 기본
 *     - 회차에 해당하는 인덱스에 적절한 수를 찾는 방식
 *     - 바깥쪽 반복문의 제어변수가 1씩 증가할 때마다, 안쪽 반복문의 반복 횟수가 1씩 감소한다.
 * </pre>
 */
public class SequentialSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};
        System.out.println("전 : " + Arrays.toString(arr));

        // i = 0, 1, 2, 3 회차(배열 인덱스), 3까지 정렬하면 인덱스 4에 요소는 자동적으로 정렬이 되어있을 것이기 때문에, 굳이 할 필요없다.
        for(int i = 0; i < arr.length - 1; i++) {
            // i = 0, j = 1, 2, 3, 4
            // i = 1, j = 2, 3, 4,
            // i = 2, j = 3, 4
            // i = 3, j = 4
            for(int j = i + 1; j < arr.length; j++) {
                // 크기 비교 (비교할 j번 요소가 더 작다면, 값교환)
                if(arr[i] > arr[j]) {
                    swap(arr, i ,j);
                }
                print(arr, i);
            }
        }

        System.out.println("후 : " + Arrays.toString(arr));
    }
}
