package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap;

/**
 * 선택정렬
 * - 각 회차에 최솟값을 찾고, 회차 마지막에 1번만 값 교환! 시간 복잡도 O(n^2)
 * - 순차정렬대비 성능이 우수하다. (교환횟수가 적음)
 */

public class SelectionSort {
    public void test(){
        int[] arr = {5,4,1,3,2};

        // i = 0,1,2,3 ( 마지막 자리는 비교하지 않음)
        for(int i = 0; i < arr.length -1; i++){
            // 최솟값을 가리키는 인덱스, 최초 i번지라고 설정
            int min = i ;

            // i = 0, j = 1,2,3,4
            // i = 1, j = 2,3,4
            // i = 2, j = 3,4
            // i = 3, j = 4
            for(int j = i + 1; j < arr.length; j++){
                if(arr[min] > arr[j]) // arr[min] > arr[j] 내림차순
                {
                    min = j; // 이제 최솟값은 j번지 // 실제 값을 바꾸지 않음 최솟값을 찾아가는거임
                    //

                    print(arr,i);
                }
                swap(arr,i,min);
            }

            System.out.println(Arrays.toString(arr));
        }

    }

    }
