package com.ssg.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        System.out.println("===문제1===");
        int[][] arr1 = new  int[4][4];
        int num = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = num++;
            }
        }
        print(arr1);
    }

    public static void test2() {
        System.out.println("===문제2===");
        int[][] arr1 = new  int[4][4];
        int num = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[j][i] = num++;
            }
        }
        print(arr1);
    }

    public static void test3() {
        System.out.println("===문제3===");
        int[][] arr1 = new  int[4][4];
        int num = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = arr1[i].length - 1; j >= 0; j--) {
                arr1[i][j] = num++;
            }
        }
        print(arr1);
    }

    public static void test4() {
        System.out.println("===문제4===");
        int[][] arr1 = new  int[4][4];
        int num = 16;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = num--;
            }
        }
        print(arr1);
    }

    public static void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
