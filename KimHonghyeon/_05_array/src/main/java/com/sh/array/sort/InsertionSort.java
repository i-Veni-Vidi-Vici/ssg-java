package com.sh.array.sort;


import java.util.Arrays;

/**
 * 삽입정렬
 * - 정렬된 배열(왼쪽)에 새로운 요소를 끼워 넣는 방식
 * - 두번째요소부터 비교연산 수행
 * - 버블정렬의 비교횟수가 많은 단점을 개선
 * - 정렬자리수를 따로 변수에 담아 두었다 적절한 자리에 삽입
 */
public class InsertionSort {

    public void test(){
        int[] arr = {5,4,1,3,2};
        for(int i =1; i<arr.length; i++){
            int j;
            int temp = arr[i];
            for(j=i;j>0;j--){
                if(arr[j-1] > temp)Swap.swap(arr,j,j-1);
                else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
