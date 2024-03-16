package com.ssg.test.multi.dimentional.array.test;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
//        sample.exercise1();
        sample.exercise2();
    }

    public void exercise1() {
        int[][] arr = new int[3][5];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100) + 1;

                if(arr[i][j] % 5 == 0) {
                    System.out.printf("%d (%d, %d)\n", arr[i][j], i, j);
                }
            }
        }
    }

    public void exercise2() {
        int[][] arr = new int[4][4];

        System.out.print("   ");
        for(int col = 0; col < arr[arr.length - 1].length; col++) {
            System.out.print(col + "열 ");
        }
        System.out.println();
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(i + "행 ");
            int sum = 0;
            if(i < arr.length - 1) {
                for(int j = 0; j < arr[i].length; j++) {
                    if(j == arr[i].length - 1) {
                        System.out.print(sum);
                    } else {
                        arr[i][j] = (int) (Math.random() * 100) + 1;
                        sum += arr[i][j];
                        System.out.print(arr[i][j] + " ");
                    }
                }
            } else{
                for(int k = 0; k < arr[i].length - 1; k++) {
                    int sum2 = 0;
                    for(int row = 0; row < arr.length - 1; row++) {
                        sum2 += arr[row][k];
                    }
                    System.out.print(sum2 + " ");
                }
            }
            System.out.println();
        }
    }
}
