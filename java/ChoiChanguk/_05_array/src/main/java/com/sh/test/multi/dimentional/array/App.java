package com.sh.test.multi.dimentional.array;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MultiDimentionalArray multiDimentionalArray=new MultiDimentionalArray();

        int cnt=1;
        int[][] arr=new int[4][4];


        //문제1
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=cnt++;
            }
        }
        multiDimentionalArray.print(arr);//문제1
        System.out.println();

        //문제2
        cnt=1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                arr[j][i]=cnt++;
            }
        }
        multiDimentionalArray.print(arr);
        System.out.println();

        //문제3
        cnt=1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=arr.length-1;j>=0;j--)
            {
                arr[i][j]=cnt++;
            }
        }
        multiDimentionalArray.print(arr);
        System.out.println();

        //문제4
        cnt=16;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                arr[j][i]=cnt--;
            }
        }
        multiDimentionalArray.print(arr);
        System.out.println();


    }
}
