package com.sh.multi.Dimension;


import java.util.Scanner;

/**
 * 가변배열
 * - 2차원 배열은 자료형이 같은 1차원 배열의 묶음
 * - 이 때 배열의 크기가 꼭 같을 필요는 없다.
 * - 2차원 배열의 크기가 다른 경우 이룰 가변배열, 같은 경우 정변배열이라 한다.
 */
public class JaggedArray {

    public void test1(){
        int[][] arr = new int[3][];
        arr[0]= new int[3];
        arr[1] = new int[2];
        arr[2] = new int[5];

        int value=1;
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = value++;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

     
}
