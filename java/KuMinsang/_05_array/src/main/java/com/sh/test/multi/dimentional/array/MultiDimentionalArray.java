package com.sh.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public void test1(){
        int[][] arr = new int[4][4];
        int cnt = 1;
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                arr[i][j] =cnt++;
            }
        }
        print(arr);
    }
    public void test2(){
        int[][] arr = new int[4][4];
        int cnt = 1;
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                arr[j][i] =cnt++;
            }
        }
        print(arr);
    }
    public void test3(){
        int[][] arr = new int[4][4];
        int cnt = 1;
        for(int i=0; i<4; i++){
            for (int j=3; j>=0; j--){
                arr[i][j] =cnt++;
            }
        }
        print(arr);
    }
    public void test4(){
        int[][] arr = new int[4][4];
        int cnt = 1;
        for(int i=3; i>=0; i--){
            for (int j=3; j>=0; j--){
                arr[j][i] =cnt++;
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
