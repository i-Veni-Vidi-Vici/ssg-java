package com.ssg.test.multi.dimentional.arry.test;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Random;
import java.util.Scanner;

public class Sample {
    public void exercise1() {

        int[][] arr=new int[3][5];

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<5;j++)
            {
                arr[i][j]=(int)(Math.random()*100)+1;
            }
        }

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(arr[i][j]%5==0)
                {
                    System.out.printf("%d (%d, %d)\n",arr[i][j],i,j);
                }
            }
        }

    }
    public void exercise2()
    {
        int[][] arr=new int[4][4];
        Scanner sc=new Scanner(System.in);
        int[] colsum=new int[]{0,0,0};
        int[] rowsum=new int[]{0,0,0};

        System.out.printf("       0열  1열  2열  3열\n");

        for(int i=0;i<3;i++)
        {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = (int) (Math.random() * 4) + 1;
                colsum[i]+=arr[i][j];
            }
        }

        for(int i=0;i<4;i++)
        {
            System.out.printf("  %d행 ",i);

            if(i<3)
            {
                for (int j = 0; j < 3; j++) {
                    rowsum[i]+=arr[j][i];
                    System.out.printf(" %2d  ", arr[i][j]);
                }

                System.out.printf("%d", colsum[i]);
            }

            else
                for(int j=0;j<3;j++) {
                    System.out.printf(" %2d  ", rowsum[j]);
                }
            System.out.printf("\n");
        }
    }
}
