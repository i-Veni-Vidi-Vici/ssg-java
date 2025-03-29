package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int value = 1;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = value++;
            System.out.print(arr[i] + "\t");
        }
    }
}
