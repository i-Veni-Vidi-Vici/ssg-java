package com.sh.array.multi.dimension.array.MultiDimentionalArray;

import java.util.Scanner;

public class Test1 {

    public void test1()
    {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[4][4];

        int value = 1;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j<arr[i].length; j++)
            {
                arr[i][j] = value++;
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
