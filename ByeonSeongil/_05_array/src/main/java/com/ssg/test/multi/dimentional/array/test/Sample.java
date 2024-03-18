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
                    System.out.printf("%d (%d, %d)\n",numbers[i][j], i,j);
                }
            }
        }
    }

}

