package com.sh.array.multi.dimension.array.MultiDimentionalArray;

public class Test3
{
    public void test3()
    {
        int value = 4;
        int k = 1;

        int[][] arr = new int[4][4];

        // 0번째에 열은 4의 배수 거기서부터 -1
        for(int i = 0; i < arr.length; i++) {

            for(int j = 0; j < arr[i].length; j++) {

               if(j==0) arr[i][0] = value * k++;
               else arr[i][j] = arr[i][j-1] - 1;
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
