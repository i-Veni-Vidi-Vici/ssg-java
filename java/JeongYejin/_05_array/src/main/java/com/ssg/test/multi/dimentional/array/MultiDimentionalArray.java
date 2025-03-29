package com.ssg.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        MultiDimentionalArray mda = new MultiDimentionalArray();
//        mda.test1();
//        mda.test2();
//        mda.test3();
        mda.test4();

    }

    public void test1() {
        int[][] arr = new int[4][4];
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
            }
        }
        print(arr);
    }

    public void test2() {
        int[][] arr = new int[4][4];
        int num = 1;
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][j] = num++;
            }
        }
        print(arr);
    }

    public void test3() {
        int[][] arr = new int[4][4];
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                arr[i][j] = num++;
            }
        }
        print(arr);
    }

    public void test4() {
        int[][] arr = new int[4][4];
        int num = 1;
        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i][j] = num++;
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
