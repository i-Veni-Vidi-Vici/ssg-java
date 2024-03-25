package com.sh.array.sort;


/**
 * - 배열 정렬 알고리즘 중 가장 기본
 * - 회차에 해당하는 인덱스에 적절한 수를 찾는 방식
 */
public class SequentialSort {

    public void test(){
        int[] arr = {5,4,3,2,1};
        for(int i =0; i< arr.length; i++){
            int min_idx = i;
            for(int j =i; j< arr.length; j++){
                if(arr[j]<arr[min_idx]){
                    min_idx = j;
                }
            }
            Swap.swap(arr, i, min_idx);
        }
        Swap.printArr(arr);
    }
}
