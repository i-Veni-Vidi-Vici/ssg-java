package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample sp = new Sample();
        sp.exercise1();
        System.out.println("----1번 문제----\n");
        sp.exercise2();
        System.out.println("----2번 문제----");
    }

    /**
     * 3행 5열의 2차원 배열을 생성하고 1~100 사이의 임의의 정수로 초기화한 후,
     * 열의 값이 5의 배수인 경우만 값을 출력합니다.
     */
    public void exercise1() {
        // 3행 5열의 2차원 배열 선언 및 생성
        int[][] array = new int[3][5];

        // 1~100 사이의 임의의 정수로 배열 초기화
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100) + 1;
            }
        }

        // 열의 값이 5의 배수인 경우만 값(행, 열) 출력
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 5 == 0) {
                    System.out.println(array[i][j] + " (" + i + ", " + j + ")");
                }
            }
        }
    }

    /**
     * 4행 4열의 2차원 배열을 생성하고 0행 0열부터 2행 2열까지 1부터 100 사이의 임의의 정수 값을 기록합니다.
     * 그리고 각 행과 열의 합계를 계산하여 배열의 마지막 행과 열에 추가하고 배열을 출력합니다.
     */
    public void exercise2() {
        // 4행 4열의 2차원 배열 선언 및 생성
        int[][] array = new int[4][4];

        // 0행 0열부터 2행 2열까지 1부터 100 사이의 임의의 정수 값 기록
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = random.nextInt(100) + 1;
            }
        }

        // 각 행과 열의 합계 계산
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += array[i][j];
            }
            array[i][3] = rowSum;
        }

        for (int j = 0; j < 4; j++) {
            int colSum = 0;
            for (int i = 0; i < 3; i++) {
                colSum += array[i][j];
            }
            array[3][j] = colSum;
        }

        // 배열 출력
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
