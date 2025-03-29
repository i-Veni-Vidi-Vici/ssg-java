package com.sh.array.sort;

public class SelectionSort {

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
