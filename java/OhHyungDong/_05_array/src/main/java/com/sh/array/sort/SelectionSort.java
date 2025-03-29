package com.sh.array.sort;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * 선택정렬
 * - 각 회차에 최소값을 찾고, 회차 마지막에 1번만 값 교환 하는 방식
 * - 순차정렬 대비 성능이 우수하다. (교환 회수가 적음 -> 일일이 교환하는게 아닌 최소값을 찾은 후에 값을 교환하는것이기 때문에 교환 횟수가 적다. )
 */
public class SelectionSort {
    public void test1() {
        int[] arr = {5, 4, 1, 3, 2};


        //마지막 자리는 비교하지 않음 -> 마지막에 자리는 알아서 정해지기 때문에.
        for (int i = 0; i < arr.length - 1; i++) { //i -> 1회차, 2회
            //최소값을 가리키는 인덱스. 최초 i번지라고 설정.
            int min = i;
            {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[min] > arr[j]) min = j; //최솟값을 찾는과정 -> 최소값을 찾아서 맨 앞자리의 값이랑 교환
                    print(arr, i);
                }
                swap(arr, i, min);
            }

        }
    }
}
