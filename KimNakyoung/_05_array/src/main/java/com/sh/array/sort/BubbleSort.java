package com.sh.array.sort;


import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * <pre>
 *  버블정렬
 *  - 인접한 두개의 요소를 검사해 정렬하는 방식
 *  - 구현이 쉬우나, 정렬 속도는 빠르지 않다.
 *  - 이미 정렬된 데이터를 다시 정렬 하는 경우 유용하다.
 *  - 바깥 반복문은 인덱스가 아닌 반복횟수를 의미한다!! 한 회차에 오른쪽부터 정렬이 완성된다.
 *
 * </pre>
 *
 *
 */
public class BubbleSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};

        // i = 4,3,2,1 안쪽 반복문의 반복횟수를 의미한다. (해당인덱스의 적절한 수를 찾게됨. 우측부터)
        for (int i = arr.length-1; i > 0; i--) {

            // i의 값은 안쪽 반복문이 몇번 도나?
            // 오른쪽 정렬
            // i = 4, j = 0, 1, 2, 3 -> 4번지에 있는 수 정렬하는거
            // i = 3, j = 0,1,2 -> 3번지에 있는 수 정렬하는거
            // i = 2, j = 0,1 -> 2번지에 있는 수 정렬하는거
            // i = 1, j = 0 -> 1번지에 있는 수 정렬하는거

            // 밀려가는 숫자 때매 버블임
            // arr[j] > arr[j + 1] 오름차순 // arr[j] < arr[j + 1] 내림차순
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
                print(arr, i);
            }

            System.out.println(Arrays.toString(arr));

        }

    }
}
