package com.sh.array.multi.dimension.array.MultiDimentionalArray;

public class Test4 {

    int[][] arr = new int[4][4];
    public void test4() {
        int a = 16;
        //열 값이 0일땐 1씩 감소
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(j==0) arr[i][j] = a--;
                else arr[i][j] = arr[i][j-1] - 4;
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
