package com.ssg.test.multi.dimention.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
//        sample.exercise1();
        sample.exercise2();
    }

    // 문제 1

    /**
     * 1. 3행 5열 2차원 배열 선언 및 생성
     * 2. 1~100사이의 임의의 정수를 모든 방에 기록함
     * 3. 열의 값이 5의 배수인 경우만 값(행,열) 출력함
     *
     */
    public void exercise1(){
        int[][] arr = new int[3][5]; // 3행 5열
        Random rnd = new Random();


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(100) +1; // 1~100까지 난수생성

                // 열의 값이 5의 배수인 경우 값(행,열) 출력
                if(arr[i][j] % 5 ==0){
                    System.out.println(arr[i][j] + "(" +i + ", " + j + ")" );
                }
            }
        }
    }

    // 문제2

    /**
     * 1. 4행 4열 2차원배열 선언 및 생성
     * 2. 0행 0열부터 2행2열까지 1부터 100사이의 임의의 정수 값 기록
     *
     */

    public void exercise2(){
//        1. 4행 4열 2차원배열 선언 및 생성
        int[][] arr = new int[4][4];
        Random rnd = new Random(); // 난수 객체

        // 2. 0행 0열부터 2행2열까지 1부터 100사이의 임의의 정수 값 기록
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = rnd.nextInt(100) + 1 ; // 100~1 난수생성
                arr[i][3] += arr[i][j]; // 행 합계
                arr[3][j] += arr[i][j]; // 열 합계
            }
        }

        //출력

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
        
    }
}
