package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("홀수를 입력하세요: ");
        int size = scanner.nextInt();
        if(size%2!=1){
            System.out.println("홀수가 아닙니다. 다시 실행하세요.");
        }
        int[] arr = new int[size];
        int val=1;
        for(int i=0; i<=size/2; i++){
            arr[i] = val++;
        }
        val--;
        for(int i = (size/2)+1; i< arr.length; i++){
            arr[i] = --val;
        }
        System.out.print("[ ");
        for(int i =0; i<arr.length; i++){
            if(i== arr.length-1){
                System.out.print(arr[i]);
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print(" ]");

    }
}
