package com.sgg.test.multi.dimentional.array;

public class MultiDimentionalArray {
    public void test()
    {
        int[][] arr = new int[4][4];
        int num=1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j] = num++;
            }

        }
        print(arr);

    }
    public void test2()
    {
        int[][] arr = new int[4][4];
        int num=1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[j][i] = num++;
            }

        }
        print(arr);
    }
    public void test3()
    {
        int[][] arr = new int[4][4];
        int num=1;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=arr[i].length-1;j>=0;j--)
            {
                arr[i][j] = num++;
            }

        }
        print(arr);
    }
    public void test4()
    {
        int[][] arr = new int[4][4];
        int num=1;
        for(int i=arr.length-1;i>=0;i--)
        {
            for(int j=arr[i].length-1;j>=0;j--)
            {
                arr[j][i] = num++;
            }

        }
        print(arr);
    }
    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
