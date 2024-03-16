package com.ssg.test.dimentional.array.test;

import java.awt.datatransfer.DataFlavor;
import java.io.FilterOutputStream;
import java.util.Random;

public class Sample {
    public void exercise1() {
        Random rnd = new Random();

        int[][] arr = new int[3][5];

        //랜덤 난수 배열 할당
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int rndNum = rnd.nextInt(1, 101);
                arr[i][j] = rndNum;
            }
        }
        //5의 배수인 열 뽑기
        for (int n = 0; n < arr.length; n++) {
            for (int m = 0; m < arr[n].length; m++) {
                if (arr[n][m] % 5 == 0) {
                    System.out.printf("%d ( %d, %d ) \n", arr[n][m], n, m);
                }
            }
        }


    }

    public void exercise2() {
        Random rnd2 = new Random();
        int[][] arr2 = new int[4][4];


        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                int rndNum = rnd2.nextInt(1, 101);
                arr2[i][j] = rndNum;
            }

        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr2[i][3] += arr2[i][j];
                arr2[3][j] += arr2[j][i];
            }
        }


        for (int i = 0; i < 3; i++) {
                System.out.printf("%d행 합계 : %d \n", i, arr2[i][3]);
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d열 합계 : %d \n", j, arr2[3][j]);
            }
        }

        //System.out.println();


    }

}
