package com.ssg.test.lotto;

import java.util.Arrays;

public class LottoApp {
    static final int selectNum=6;
    public static void main(String[] args) {
        int[] numbers = new int[selectNum];
        for(int i =0; i<selectNum;i++){
            numbers[i] = (int)(Math.random()*45)+1;
        }
        for(int i =1; i<selectNum; i++){
            int j;
            for(j=i; j>0;j--){
                if(numbers[j]<numbers[j-1])swap(numbers,j, j-1);
                else break;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
    public static void swap(int[] arr, int i, int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
