package com.ssg.test.multi.dimentional.array.test.Sample;

public class Exercise {
    public void exercise1(){
        int[][] arr = new int[3][5];

        int i = 0, j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random()*100)+1);
            }
        }

        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 5 == 0) {
                    System.out.printf("%d\t( %d, %d )\n", arr[i][j], i, j);
                }
            }
        }
    }

    public void exercise2(){
        int[][] arr = new int[4][4];

        int i = 0, j = 0;
        int count=1;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                if (i < arr.length - 1 && j < arr[i].length - 1) {
                    arr[i][j] = (int) ((Math.random()*100)+1);
                    //arr[i][j] = count++;
                    arr[i][arr[i].length-1] = arr[i][arr[i].length-1] + arr[i][j]; // 행의 합계
                    arr[arr.length-1][j] = arr[arr.length-1][j] + arr[i][j]; // 열의 합계
                }
            }
        }
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }




    }
}
