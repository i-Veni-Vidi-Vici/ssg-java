package com.ssg.test.multi.dimentional.array.test;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.exercise1();
        sample.exercise2();
    }

    public void exercise1() {
        int[][] arr = new int[3][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(Math.random()*100 + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 5 == 0) {
                    System.out.printf("%d (%d, %d)\n", arr[i][j], i, j);
                }
            }
        }
    }

    public void exercise2() {
        int[][] arr = new int[4][4];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                arr[i][j] = (int)(Math.random()*100 + 1);
            }
        }
        // 행 합계
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                arr[i][3] += arr[i][j];
            }
        }
        // 열 합계
        for (int j = 0; j < arr[0].length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                arr[3][j] += arr[i][j];
            }
        }
        //출력
        System.out.println("   0열 1열 2열 3열");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i +"행 ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[i].length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
