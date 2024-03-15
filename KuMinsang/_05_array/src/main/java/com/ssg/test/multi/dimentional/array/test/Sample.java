package com.ssg.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        Sample run1 = new Sample();
        //run1.exercise1();
        run1.exercise2();
    }
    public void exercise1(){
        Random rnd = new Random();

        int [][] arr = new int[3][5];

        for(int i =0; i<3; i++){
            for(int j=0; j<5; j++) {
                arr[i][j] = rnd.nextInt(100)+1; //0~99 +1
                if(arr[i][j]%5==0){
                    System.out.printf("%d (%d, %d)\n", arr[i][j], i, j);
                }
            }
        }

    }

    public void exercise2(){
        int rowsum=0;
        int colsum=0;
        Random rnd = new Random();
        int [][] nums = new int[4][4];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                nums[i][j] = rnd.nextInt(100)+1;
            }
        }

        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                rowsum += nums[i][j];
                colsum += nums[j][i];
            }
            nums[i][3] = rowsum;
            nums[3][i] = colsum;
            rowsum=0;
            colsum=0;
        }


        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print(nums[i][j] +" ");
            }
            System.out.println();

        }

    }
}
