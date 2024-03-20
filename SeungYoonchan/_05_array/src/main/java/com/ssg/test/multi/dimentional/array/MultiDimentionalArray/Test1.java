package com.ssg.test.multi.dimentional.array.MultiDimentionalArray;
import static com.ssg.test.multi.dimentional.array.MultiDimentionalArray.Print.print;

public class Test1 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }
        print(arr);
    }
}
