package com.array;

public class app3 {

    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int cnt = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 3; j >= 0; --j){
                arr[i][j] = cnt++;
            }
        }
        print(arr);
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
