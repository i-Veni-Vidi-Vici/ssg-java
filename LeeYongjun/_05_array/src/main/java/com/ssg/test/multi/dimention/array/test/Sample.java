package com.ssg.test.multi.dimention.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.exercise1();
        sample.exercise2();
    }

    private void exercise1() {
        Random rnd = new Random();
        int[][]arr = new int[3][5];

        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(100) + 1;
                if(arr[i][j] % 5 == 0){
                    System.out.println(arr[i][j] + "(" +i + ", " + j + ")" );
                }
            }
        }
    }

    private void exercise2() {
        Random rnd = new Random();
        int[][]arr = new int[4][4];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = rnd.nextInt(100) + 1;
                arr[i][3] += arr[i][j];
                arr[3][j] += arr[i][j];
            }
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
