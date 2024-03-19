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
        int col0Sum = 0;
        int col1Sum = 0;
        int col2Sum = 0;

        for (int i = 0; i < arr.length; i++){
            int rowSum = 0; // 행마다 초기화 되어야하므로, inner loop 전에 작성
            for (int j = 0; j < arr[i].length; j++){
                // 0, 1, 2행인 경우
                if (i != arr.length - 1){
                    int rnd = (int) (Math.random() * 100) + 1;
                    // 그 안에 0, 1, 2열인 경우
                    if (j != arr[i].length - 1){
                        arr[i][j] = rnd;
                        rowSum += rnd;
                        // 세로합
                        switch (j){
                            case 0:
                                col0Sum += rnd;
                                break;
                            case 1:
                                col1Sum += rnd;
                                break;
                            case 2:
                                col2Sum += rnd;
                                break;
                        }
                    }
                    // 3열인 경우 합계
                    else {
                        arr[i][j] = rowSum;
                    }
                }
                // 3행인 경우 합계
                else {
                    switch (j){
                        case 0:
                            arr[i][j] += col0Sum;
                            break;
                        case 1:
                            arr[i][j] += col1Sum;
                            break;
                        case 2:
                            arr[i][j] += col2Sum;
                            break;
                    }
                }
            }
        }

        System.out.printf("\t0열\t1열\t2열\t3열\n");
        for (int i = 0; i < arr.length; i++){
            System.out.print(i + "행\t");
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
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
