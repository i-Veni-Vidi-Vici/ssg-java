package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
//        sample.exercise1();
        sample.exercise2();
    }

    public void exercise1() {
        Random rnd = new Random();
        int[][] arr = new int[3][5];
        int rndNum = 0; // 1~100 사이의 임의의 정수

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                rndNum = rnd.nextInt(100) + 1;
                arr[i][j] = rndNum;

                if(rndNum%5 == 0) { // 열의 값이 5의 배수인 경우
                    System.out.printf("%d (%d, %d)\n", rndNum, i, j);
                }
            }
        }
    }

    public void exercise2() {
        Random rnd = new Random();
        int rndNum = 0; // 1~100 사이의 임의의 정수
        int[][] arr = new int[4][4];
        System.out.println("\t0열\t1열\t2열\t3열");

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                rndNum = rnd.nextInt(100) + 1;
                arr[i][j] = rndNum;

                if(i == arr.length-1) // 3행
                    arr[i][j] = arr[0][j] + arr[1][j] + arr[2][j];

                if(j == arr[i].length-1)   // 3열
                    arr[i][j] = arr[i][0] + arr[i][1] + arr[i][2];

                arr[arr.length-1][arr[i].length-1] = 0; // 3행 3열
            }

            System.out.printf("%d행\t%d\t%d\t%d\t%d\n", i, arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
        }
    }
}
