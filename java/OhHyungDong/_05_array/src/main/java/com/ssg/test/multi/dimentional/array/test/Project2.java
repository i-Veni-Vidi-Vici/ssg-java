package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Project2
{
    public void  exercise2()
    {
        int[][] arr = new int[4][4];
        Random rnd = new Random();
        int random;

        for(int i =0; i<arr.length; i++)
        {
            for(int j = 0; j<arr[i].length; j++)
            {
                // 0행 0열 - 2행 2열 랜덤 값 대입
                if((i >=0 && i<=2) && (j>=0 && j<=2))
                {
                    random = rnd.nextInt(100) + 1;
                    arr[i][j] = random;
                }

            }
        }
        // 나머지 값 대입
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                arr[i][3] += arr[i][j];
                arr[3][i] += arr[j][i];
            }
        }


        System.out.println("0열  1열  2열  3열 ");
        for(int i = 0; i<arr.length; i++)
        {
            System.out.print(i + "행 ");
            for(int j = 0; j<arr[i].length; j++ )
            {

                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
