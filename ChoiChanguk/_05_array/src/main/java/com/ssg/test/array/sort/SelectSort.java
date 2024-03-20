package com.ssg.test.array.sort;

import java.util.Arrays;

import static com.ssg.test.array.sort.Swap.print;
import static com.ssg.test.array.sort.Swap.swap;


/**
 * 선택정렬
 *  - 각 회차에 최소값을 찾고, 회차 마지막에 1번만 값교환하는 방식
 *  - 순차정렬 대비 성능이 우수하다. (교환회수가 적음)
 */
public class SelectSort {
    public void test() {
        int[] arr = {5, 4, 1, 3, 2};

        for(int i=0;i<arr.length-1;i++)
        {
            // 최소값을 가리키는 인덱스, 최초 i번지라고 설정
            int min=i;
            for(int j=i+1;i<arr.length;i++)
            {
                if(arr[min]>arr[j])
                {
                    min=j;
                }
                print(arr,i);
            }
            swap(arr,i,min);

        }
        System.out.println(Arrays.toString(arr));
    }
}
