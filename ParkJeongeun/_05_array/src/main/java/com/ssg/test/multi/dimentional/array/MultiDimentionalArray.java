package com.ssg.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public void test() {
        int[][] arr = new int[4][4];
        int k = 1;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = k++;
            }
        }
        print(arr);
    }

    public void test2() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++){
            int k = i + 1;
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = k;
                k += 4;
            }
        }
        print(arr);
    }

    public void test3() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++){
            int k = 16 - i;
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = k;
                k -= 4;
            }
        }
        print(arr);
    }

    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
