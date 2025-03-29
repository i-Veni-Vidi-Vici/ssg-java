package com.ssg.test.muti.dimentional.array.test;



public class MultiDimentionalArray {
    public void test1() {
        int[][] arr = new int[4][4];
        int count = 1;

        // 값 대입
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }

        // 값 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    }
