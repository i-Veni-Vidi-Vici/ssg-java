package com.ssg.test.multi.dimentional.array.test;

public class Sample {
    public void exercise1() {
        // 3행 5열 2차원배열 선언 및 생성
        int[][] arr = new int[3][5];

        // 1~100 사이의 임의의 정수로 모든 배열 요소에 대입
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100) + 1;
            }
        }

        // 열의 값이 5의 배수인 경우만 값(행,열) 출력함
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] % 5 == 0)
                    System.out.printf("%d (%d, %d)\n", arr[i][j], i, j);
            }
        }
    }

    public void exercise2() {
        // 4행4열 2차원배열 선언 및 생성
        int[][] arr = new int[4][4];

        // 0행 0열부터 2행 2열까지 1부터 100사이의 임의의 정수값 기록
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr[i].length - 1; j++) {
                arr[i][j] = (int) (Math.random() * 100) + 1;
            }
        }

        // 각 행, 각 열별 합계 연산
        // 각 행별 합계 연산
        for(int i = 0; i < arr.length - 1; i++) {
            int rowSum = 0;
            for(int j = 0; j < arr[i].length - 1; j++) {
                rowSum += arr[i][j];
            }
            arr[i][3] = rowSum;
        }

        // 각 열별 합계 연산
        for(int i = 0; i < arr.length - 1; i++) {
            int colSum = 0;
            for(int j = 0; j < arr[i].length - 1; j++) {
                colSum += arr[j][i];
            }
            arr[3][i] = colSum;
        }

        // 출력
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
