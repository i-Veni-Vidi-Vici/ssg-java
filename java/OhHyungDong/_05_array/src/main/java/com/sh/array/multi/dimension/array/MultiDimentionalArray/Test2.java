package com.sh.array.multi.dimension.array.MultiDimentionalArray;

public class Test2
{
    int row = 1;
    int column = 2;
    public void test2()
    {
        int[][] arr = new int[4][4];
        int row = 1;
        int column = 4;
        for(int i = 0; i < arr.length; i++) {
            // 열이 0일때는 +1 열이 0이 아닐때는 +4
            for(int j = 0; j < arr[i].length; j++) {
//                if(j==0) arr[i][0] = value * k++;
//                else arr[i][j] = arr[i][j-1] - 1;
               if(j == 0) arr[i][0] = row++;
               else arr[i][j] = arr[i][j-1] + 4;
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
