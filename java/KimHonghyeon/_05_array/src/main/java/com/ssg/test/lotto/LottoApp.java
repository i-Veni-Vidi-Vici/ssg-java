package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LottoApp {
    static final int selectNum=6;
    public static void main(String[] args) {
        Set numSet = new HashSet();
        while(numSet.size()<6){
            numSet.add((int)(Math.random()*45)+1);
        }
        Object[] sortedNumSet = numSet.stream().sorted().toArray();
        int[] numbers = new int[selectNum];
        for(int i =0; i<selectNum; i++){
            numbers[i] = (int)sortedNumSet[i];
        }
        System.out.println(Arrays.toString(numbers));
    }
    public static void swap(int[] arr, int i, int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
