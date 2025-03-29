package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample s = new Sample();
//        s.exercise1();
        s.exercise2();
    }
    public void exercise1() {
        int[][] arr = new int[3][5];
        Random rnd = new Random();
        // 배열에 1~100 사이의 임의의 정수값 넣기
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(1, 101);
                // 값 (행, 열) 형식으로 출력하기
                if(arr[i][j] % 5 == 0) {
                    System.out.printf("%d (%d, %d)\n", arr[i][j], i, j);
                }
            }
        }
    }

    public void exercise2() {
        int[][] arr = new int[4][4];
        Random rnd = new Random();
        int rowSum = 0;
        int colSum = 0;
        // 배열에 값대입
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                // 행열에 1부터 100사이의 임의의 정수 값 기록
                arr[i][j] = rnd.nextInt(1, 101);
                // 행 합계와 열합계 추가
                if(j == 3) {
                    rowSum = arr[i][0] + arr[i][1] + arr[i][2];
                    arr[i][3] = rowSum;
                }
                else if(i == 3) {
                    colSum = arr[0][j] + arr[1][j] + arr[2][j];
                    arr[3][j] = colSum;
                }
                arr[3][3] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
