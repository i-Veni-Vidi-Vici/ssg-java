package com.sgg.test.multi.dimentional.array;

import java.util.Random;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 exercise2 = new Exercise2();
        exercise2.exercise2();
    }
    public void exercise2(){
        int sum=0,sum1=0;
        Random rnd = new Random();
        int[][] arr = new int[4][4];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j]=rnd.nextInt(100)+1;
            }
        }
        for(int i =0;i<3;i++)
        {
          for(int j=0;j<3;j++)
          {
              sum += arr[i][j];
              sum1 += arr[j][i];

          }
          arr[i][3]=sum;
          arr[3][i]=sum1;
          sum=0;
          sum1=0;
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0; j<4;j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }
}
