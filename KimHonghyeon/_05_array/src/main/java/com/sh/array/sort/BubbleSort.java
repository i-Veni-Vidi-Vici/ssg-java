package com.sh.array.sort;

import java.util.Arrays;

/**
 * 버블정렬
 * - 인접한 두개의 요소를 검사해 정렬하는 방식
 * - 구현은 쉬우나 정렬속도는 빠르지 않다.
 * - 이미 정렬된 데이터를 다시 정렬하는 경우
 * -
 */
public class BubbleSort {
    public void test(){
        int[] arr ={5,4,3,2,1};
        for(int i = arr.length-1; i>0; i--){
            for(int j = 0; j<i; j++){
                if(arr[j] > arr[j+1])Swap.swap(arr,j,j+1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
