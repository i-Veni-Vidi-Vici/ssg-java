package com.ssg.test.multi.dimentioal.array.test;

public class Sample {

    public void exercise1() {
        System.out.println("-문제 1-");
        int[][] arr = new int[3][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100) + 1;

                if (arr[i][j] % 5 == 0) {
                    System.out.println(arr[i][j] + " (" + i + ", " + j + ")");
                }
            }
        }

        System.out.println("행렬 출력 :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void exercise2() {
        System.out.println("-문제 2-");
        int[][] arr = new int[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == arr.length - 1){
                    arr[i][j] = arr[0][j] + arr[1][j] + arr[2][j];
                    continue;
                }

                if (j == arr[i].length - 1) {
                    arr[i][j] = arr[i][0] + arr[i][1] + arr[i][2];
                    continue;
                }
                arr[i][j] = (int) (Math.random() * 100) + 1;
            }
        }
        arr[arr.length - 1][arr.length - 1] = 0;

        System.out.println("행렬 출력 :");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.exercise1();
        System.out.println();
        sample.exercise2();
    }
}
