package com.ssg.test.multi.dimentional.array;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        //문제1
        int[][] arr1 = new int[4][4];
        int val = 1;
        for(int i=0; i<arr1.length; i++){
            for(int j =0; j<arr1[i].length; j++){
                arr1[i][j] = val++;
            }
        }
        print(arr1);
        System.out.println();

        //문제2
        val=1;
        int[][] arr2 = new int[4][4];
        for(int i=0; i<arr2.length; i++){
            for(int j =0; j<arr2[i].length; j++){
                arr2[j][i] = val++;
            }
        }
        print(arr2);
        System.out.println();

        //문제3
        val=1;
        int[][] arr3 = new int[4][4];
        for(int i=0; i<arr3.length; i++){
            for(int j =arr3[i].length-1; j>=0; j--){
                arr3[i][j] = val++;
            }
        }
        print(arr3);
        System.out.println();

        //문제4
        val=1;
        int[][] arr4 = new int[4][4];
        for(int i= arr4.length-1; i>=0; i--){
            for(int j =arr4[i].length-1; j>=0; j--){
                arr4[j][i] = val++;
            }
        }
        print(arr4);
        System.out.println();

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
