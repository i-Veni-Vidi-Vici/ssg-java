package com.ssg.test.multi.dimentional.array.MultiDimentionalArray;

import static com.ssg.test.multi.dimentional.array.MultiDimentionalArray.Print.print;

public class Test4 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        int value = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                arr[j][i] = value++;
            }
        }

        print(arr);
    }
}
