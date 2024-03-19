package com.ssg.test.multi.dimentional.array.test;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        MultiDimentionalArray m = new MultiDimentionalArray();
        m.test1();

    }

    public void test1() {
        int[][] arr = new int[4][4];
        int sum = 1;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j <arr[i].length; j++) {
                arr[i][j] = sum++;
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
