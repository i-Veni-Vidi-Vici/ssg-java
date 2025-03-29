package com.sh.array.copy.sort;

import static com.sh.array.copy.sort.Swap.print;
import static com.sh.array.copy.sort.Swap.swap;

/**
 * 선택정렬
 *
 * - 각 회차에 최소 값을 찾고, 회차 마지막에 1번만 값 교환하는 방식
 * - 순차 정렬 대비 성능이 우수하다.
 *
 */
public class SelectionSort {
    public void test1(){
        int[] arr = {5,4,3,2,1};
        // i = 0, 1,2,3 (마지막 자리는 비교하지 않음)
        for(int i =0; i< arr.length-1; i++) {
            //최소 값을 가르키는 인덱스
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[min]>arr[j])
                    min = j;    //최소값이 있는 인덱스를 저장
                //이 다음 회차부터는 최소값과 j번째 값을 비교하게됨
            }
            swap(arr,i,min);
            Swap.print(arr,i);
        }
    }
}
