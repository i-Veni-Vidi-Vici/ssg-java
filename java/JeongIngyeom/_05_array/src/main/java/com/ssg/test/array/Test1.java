package com.ssg.test.array;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i - 1] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
