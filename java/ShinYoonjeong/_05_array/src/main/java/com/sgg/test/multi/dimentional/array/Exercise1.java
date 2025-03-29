package com.sgg.test.multi.dimentional.array;

import java.util.Random;

public class Exercise1 {
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        exercise1.exercise1();
    }
    public void exercise1(){
        int[][] arr = new int[3][5];
        Random rnd = new Random();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<5;j++){
                arr[i][j] = rnd.nextInt(100)+1;
            }
        }
        for(int i=0;i< arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]%5==0){
                    System.out.println(arr[i][j] + "("+i+","+j+")");
                }
            }
        }


    }
}
