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

    }
}
