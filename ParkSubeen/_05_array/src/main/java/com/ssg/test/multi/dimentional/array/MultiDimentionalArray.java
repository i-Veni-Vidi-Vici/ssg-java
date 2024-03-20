package com.ssg.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        MultiDimentionalArray test = new MultiDimentionalArray();
        test.test1();
        test.test2();
        test.test3();
        test.test4();
    }

    public void test1() {
        int[][] arr = new int[4][4];

        int num = 1;
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++) {
                arr[row][col] = num++;
            }
        }
        print(arr);
    }

    public void test2() {
        int[][] arr = new int[4][4];

        int num = 1;
        int colLen = arr[arr.length - 1].length;
        for(int col = 0; col < colLen; col++) {
            for(int row = 0; row < arr.length; row++) {
                arr[row][col] = num++;
            }
        }
        print(arr);
    }

    public void test3() {
        int[][] arr = new int[4][4];

        int num = 1;
        for(int row = 0; row < arr.length; row++) {
            for(int col = arr[row].length - 1; col >= 0; col--) {
                arr[row][col] = num++;
            }
        }
        print(arr);
    }

    public void test4() {
        int[][] arr = new int[4][4];

        int num = 1;
        int rowLen = arr.length - 1;
        int colLen = arr[rowLen].length - 1;
        for(int col = colLen; col >= 0; col--) {
            for(int row = rowLen; row >= 0; row--) {
                arr[row][col] = num++;
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
