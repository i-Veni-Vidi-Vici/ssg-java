package com.ssg.test.array;

import com.sh.array.Array1;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[100];

        for(int i = 0; i < 100; i++){
            arr[i] = i + 1;
            System.out.println(arr[i] + " ");
        }
    }
}
