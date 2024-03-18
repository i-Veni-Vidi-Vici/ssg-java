package com.sh.test.multi.dimentional.array;

public class MultiDimentionalArray {
    // 문제 1
    public void test1(){
        // 2차원 배열 선언 및 생성
        int[][] arr = new int[4][4];

        // 2차원 배열에 값 대입
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }

        // 2차원 배열 출력
        print(arr);
    }

    // 문제 2
    public void test2() {
        // 2차원 배열 선언 및 생성
        int[][] arr = new int[4][4];

        // 2차원 배열에 값 대입
        int value = 1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[j][i] = value++;
            }
        }

/*
        int value = 1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[j][i] = value;
                value += 4;
            }
            value -=11;
        }
*/

        // 2차원 배열 출력
        print(arr);
    }

    // 2차원 배열 출력하는 메소드
    public void print (int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
