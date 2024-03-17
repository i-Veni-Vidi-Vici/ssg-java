package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Project1 {

    public void exercise1()
    {
        int[][] arr = new int[3][5];
        Random rnd = new Random();

        int random ;

        // 값 초기화
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j< arr[i].length;j++)
            {
                random = rnd.nextInt(100) + 1;
                arr[i][j] = random;
            }
        }

        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j< arr[i].length;j++)
            {
                if(arr[i][j] % 5 == 0)
                {
                    System.out.println(arr[i][j] + "(" + i + " ,"+ j +")");
                }
            }
        }

    }
}
