package com.sh.test.multi.dimentional.array.test;

import java.util.Random;
/**
 * - 문제1 구현내용 :
 *     1. 3행 5열 2차원 배열 선언 및 생성
 *     2. 1~100사이의 임의의 정수를 모든 방에 기록함
 *     3. 열의 값이 5의 배수인 경우만 값(행,열) 출력함
 *  출력예시
 *     - `값 (행, 열)` 형식으로 출력
 *     5 (0, 1)
 *     25 (1, 3)
 *     35 (1, 4)
 *     ...
 *
 * - 문제2 구현내용 :
     * 1. 4행4열 2차원배열 선언 및 생성
     * 2. 0행0열부터 2행2열까지 1부터 100사이의 임의의 정수 값 기록
     * 3. 행열표로 나타내기
 */
public class Sample {
    public static void main(String[] args){
        Sample sp = new Sample();
        sp.exercise1();
        sp.exercise2();
    }

    public void exercise1(){
        Random rnd = new Random();
        int[][] arr = new int[3][5];

        System.out.println("------실습문제1-------");
        System.out.println("열의 값이 5의 배수인 (행,열)");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = rnd.nextInt(100)+1;
                if(arr[i][j]%5==0){
                    System.out.printf("%d (%d, %d)\n",arr[i][j],i,j);
                }
            }
        }
    }

    public void exercise2(){
        Random rnd = new Random();
        int[][] arr = new int[4][4];

        System.out.println("\n------실습문제2-------");
        // 2행2열까지 대입
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                arr[i][j] = rnd.nextInt(100)+1;
            }
        }

        //3행,3열 대입
        for(int i= 0; i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][3] += arr[i][j];
                arr[3][i] += arr[j][i];
            }
        }

        System.out.println("   0열 1열 2열 3열 ");
        //행,열 출력하기
        for(int i=0;i<arr.length;i++){
            System.out.print(i+"행");
            for(int j=0;j<arr[i].length;j++){
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }


}
