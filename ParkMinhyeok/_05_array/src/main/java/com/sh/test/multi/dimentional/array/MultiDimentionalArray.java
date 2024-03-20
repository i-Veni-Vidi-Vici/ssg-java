package com.sh.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public static void main(String[] args) {

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
