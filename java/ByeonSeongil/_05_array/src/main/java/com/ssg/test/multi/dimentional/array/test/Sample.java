package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {

    public void exercise1() {
        int[][] numbers = new int[3][5];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = random.nextInt(100) + 1;

                if (numbers[i][j] % 5 == 0) {
                    System.out.printf("%d (%d, %d)\n", numbers[i][j], i, j);
                }
            }
        }
    }

    public void exercise2() {
        int[][] numbers = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < numbers[i].length; j++) {
                if (i <= 2 && j <= 2) {
                    numbers[i][j] = random.nextInt(100) + 1;
                    rowSum += numbers[i][j];
                } else {
                    numbers[i][j] = rowSum;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int colSum = 0;

            for (int j = 0; j < 4; j++) {
                if (i <= 2 && j <= 2) {
                    colSum += numbers[j][i];
                } else {
                    numbers[j][i] = colSum;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("%d ", numbers[i][j]);
            }
            System.out.println();
        }
    }
}

