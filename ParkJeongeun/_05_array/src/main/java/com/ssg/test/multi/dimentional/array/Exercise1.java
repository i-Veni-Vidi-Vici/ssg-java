package com.ssg.test.multi.dimentional.array;

public class Exercise1 {
    public void exercise1() {
        int[][] arr = new int[3][5];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                int rnd = (int) (Math.random() * 100) + 1;
                arr[i][j] = rnd;
                if (arr[i][j] % 5 == 0){
                    System.out.printf("%d (%d, %d)\n", rnd, i, j);
                }
            }
        }
    }

    public void exercise2() {
        int[][] arr = new int[4][4];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = (int) (Math.random() * 100) + 1;
            }
        }

        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++){
                sum += arr[i][j];
                System.out.print(arr[i][j] + "\t");
            }
        }

//        if (i == arr[i].length - 1){
//            int sum = 0;
//            for (int k = 0; k < arr.length - 1; k++){
//                sum += arr[k][j];
//                arr[i][j] = sum;
//                break;
//            }
//        }
//        if (j == arr[i].length - 1){
//            int sum = 0;
//            for (int k = 0; k < arr.length - 1; k++){
//                sum += arr[i][k];
//                arr[i][j] = sum;
//            }
//        }

        //  i  j
//        arr[3][0] = arr[0][0] + arr[1][0] + arr[2][0];
//        arr[3][1] = arr[0][1] + arr[1][1] + arr[2][1];
//        arr[3][2] = arr[0][2] + arr[1][2] + arr[2][2];
//
//        arr[0][3] = arr[0][0] + arr[0][1] + arr[0][2];
//        arr[1][3] = arr[1][0] + arr[1][1] + arr[1][2];
//        arr[2][3] = arr[2][0] + arr[2][1] + arr[2][2];

//        System.out.printf("\t0열\t1열\t2열\t3열\n");
//        for (int i = 0; i < arr.length; i++){
//            for (int j = 0; j < arr[i].length; j++){
//                if (j == arr[i].length - 1){
//                    System.out.println(arr[i][j]);
//                }
//                System.out.print(arr[i][j] + ", ");
//            }
//        }
    }
}
