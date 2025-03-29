package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args) {
        int arr[] = new int [100];

        int num = 1;
        for (int i = 0; i< arr.length; i++) {
            arr[i] = num++;
            System.out.println(arr[i]);
        }
    }
}
