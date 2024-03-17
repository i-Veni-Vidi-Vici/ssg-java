package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.exercise1();
        sample.exercise2();
    }

    public void exercise1() {
        System.out.println("===실습문제1===");
        int[][] arr = new int[3][5];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(100) + 1;
                if (arr[i][j] % 5== 0) {
                    System.out.printf("%d (%d, %d)\n", arr[i][j], i, j);
                }
            }
        }
    }

    public void exercise2() {
        System.out.println("===실습문제2===");
        int[][] arr = new int[4][4];
        Random rnd = new Random();

        int rowSum;
        int colSum;
        String colSumStr = "";
        for (int i = 0; i < arr.length; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(100) + 1;
                System.out.print(arr[i][j]);
                // 정렬을 위한 공백
                for (int k = 0; k < 4 - (Math.log10(arr[i][j]) + 1); k++) {
                    System.out.print(" ");
                }
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            System.out.println(rowSum);
            colSumStr += colSum;
            // 정렬을 위한 공백
            for (int k = 0; k < 4 - (Math.log10(colSum) + 1); k++) {
                colSumStr += " ";
            }
        }
        System.out.println(colSumStr);
    }
}
