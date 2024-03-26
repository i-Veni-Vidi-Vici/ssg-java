package com.sh.array.copy;

import java.util.Scanner;

public class shallowCopy {

    public void test2(){
        int[] arr = {1,2,3};
        print(arr);
    }

    public void print(int[] arr){
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public void test4(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("시작 정수 입력: ");
        int from = scanner.nextInt();
        System.out.print("끝 정수 입력: ");
        int to = scanner.nextInt();
        int[] arr = generateArray(from, to);
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int[] generateArray(int from, int to){
        int[] arr = new int[to-from+1];
        int val = from;
        for(int i =0; i< arr.length; i++){
            arr[i] = val++;
        }
        return arr;
    }
}
