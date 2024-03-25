package com.ssg.test.multi.dimention.array.test;

public class multiDimentionalArray {

    public static void main(String[] args) {
        multiDimentionalArray multiDimentionalArray = new multiDimentionalArray();
        multiDimentionalArray.test1();
        multiDimentionalArray.test2();
        multiDimentionalArray.test3();
        multiDimentionalArray.test4();

    }



    private void test1() {
        int count = 1;
        int[][]arr = new int[4][4];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }
        print(arr);
        System.out.println();

    }

    private void test2() {
        int count = 1;
        int[][]arr = new int[4][4];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[j][i] = count++;
            }
        }
        print(arr);
        System.out.println();
    }

    private void test3() {
        int count = 1;
        int[][]arr = new int[4][4];

        for(int i = 0; i < arr.length; i++) {
            for(int j = arr.length - 1; j >= 0; j--) {
                arr[i][j] = count++;
            }
        }
        print(arr);
        System.out.println();
    }

    private void test4() {
        int count = 16;
        int[][]arr = new int[4][4];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[j][i] = count--;
            }
        }
        print(arr);
        System.out.println();
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
