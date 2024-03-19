package com.ssg.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public void test1() {
        int[][] arr = new int[4][4];

        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n++;
            }
        }
        print(arr);
    }

    public void test2() {
        int[][] arr = new int[4][4];

        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[j][i] = n++;
            }
        }
        print(arr);
    }

    public void test3() {
        int[][] arr = new int[4][4];

        int n = 16;
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n--;
            }
        }
        print(arr);
    }

    public void test4() {
        int[][] arr = new int[4][4];

        int n = 16;
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n--;
            }
        }
        print(arr);
    }

    public void test5() {

    }

    public void test6() {

    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

