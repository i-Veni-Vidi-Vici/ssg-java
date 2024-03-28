package com.ssg.test.multi.dimentional.array;


public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.exercise1();
        sample.exercise2();
    }

    /**
     * 1. 3행 5열 2차원 배열 선언 및 생성
     * 2. 1 ~ 100 사이의 임의의 정수를 모든 방에 기록함
     * 3. 열의 값이 5의 배수인 경우만 값(행, 열) 출력함
     */
    private void exercise1() {
        int[][] arr = new int[3][5];  // 3행 5열 선언 및 생성

        for(int row = 0; row < arr.length; row++) {  // 행
            for(int col = 0; col < arr[row].length; col++) {  // 열
                arr[row][col] = (int)(Math.random() * 100) + 1;

                if(arr[row][col] % 5 == 0) {
                    System.out.printf("%d(%d,%d)%n", arr[row][col], row, col);

                }
            }
        }

    }

    /**
     * 1. 4행4열 2차원배열 선언 및 생성
     * 2. 0행0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록
     * 3. 아래의 내용처럼 처리함
     *        | 0열 | 1열 | 2열 | 3열 |
     * | 0행 | 난수 | 난수 | 난수 | 0행 합게  |
     * | 1행 | 난수 | 난수 | 난수 | 1행 합계 |
     * | 2행 | 난수 | 난수 | 난수 | 2행 합계 |
     * | 3행 | 0열 합계 | 1열 합계 | 2열 합계 |
     */
    private void exercise2() {
        int[][] arr = new int[4][4]; // 4행 4열 선언 및 생성

        // 0행0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록
        for(int i = 0; i < arr.length; i++){ // 행
            for(int j = 0; j < 3; j++){  // 열
                arr[i][j] = (int)(Math.random()*100) + 1;
            }
        }

        // 각 행과 열의 합계
        int rowSum = 0;
        for(int i = 0; i < 3; i ++){ // 행의 합

        }

    }
}
