package com.ssg;

import java.util.Random;

public class multiArray {
    public static void main(String[] args) {
        Random random = new Random();
        int maxX = 4;
        int maxY = 4;
        int[][] arr = new int[maxX][maxY];
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                arr[i][j] = random.nextInt(99) +1;
                arr[i][maxY-1] += arr[i][j];
                arr[maxX-1][i] += arr[i][j];
            }
        }
        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < 4; ++j){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
