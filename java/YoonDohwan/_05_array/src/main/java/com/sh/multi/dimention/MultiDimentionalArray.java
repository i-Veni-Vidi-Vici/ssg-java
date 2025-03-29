package com.sh.multi.dimention;

import java.util.Scanner;

/**
 * 다차원 배열
 * -2차원 이상의 배열을 의미
 * -배열 인덱스마다 다른 배열의 주소를 가지고 있다.
 * -1차원 배열을 묶어서 관리하는 것.
 * -3차원 이상도 가능은 하지만 자주 사용되지 않는다.
 *
 * 다차원배열 사용법
 * 1.배열변수 선언
 * 2.1차원 배열을 n개 관리하는 첫번째 배열 객체를 할당
 * 3.첫번째 배열의 인덱스별로 두번째 배열을 할당
 * 4.두번째 배열의 인덱스별로 값을 대입해서 사용.
 *
 */
public class MultiDimentionalArray {
    public void test1() {
        int[][] arr;
        //1차원 배열을 관리하는 첫번째 배열 객체 할당
        arr = new int[3][];
        //첫번째 배열 각인덱스에 두번째 1차원배열을 할당
        arr[0]=new int[2];
        arr[1]=new int[2];
        arr[2]=new int[2];
        //두번째 배열의 각 인덱스별로 값 할당
        arr[0][0]=10;
        arr[0][1]=10;
        arr[1][0]=10;
        arr[1][1]=10;
        arr[2][0]=10;
        arr[2][1]=10;
        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[1][0]);
        System.out.println(arr[1][1]);
        System.out.println(arr[2][0]);
        System.out.println(arr[2][1]);

    }
    public void test2(){
        //배열변수 선언 + 1차원배열(3) 할당 + 2차원배열(2)할당
        int[][] arr=new int[3][2];
        //값대입
        arr[0][0]=100;
        arr[0][1]=200;
        arr[1][0]=300;
        arr[1][1]=400;
        arr[2][0]=500;
        arr[2][1]=600;
        //값출력
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                System.out.println(arr[i][j]);

            }
            System.out.println();
        }
    }
    public void test3(){
        //학생들의 점수 데이터
        // A 90 70 55 80
        // B 100 95 100 50
        // c 80 75 90 99
        int arr[][]=new int[3][4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            System.out.println((i+1)+"번의 국어 영어 수학 자바 점수를 입력하시오 : ");
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=sc.nextInt();

            }
            sc.nextLine();
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }





    }
    public void test4(){
        int[][] nums = {
                {1,2,3},{4,5,6}
        };
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void test5(){
        int [][] arr = new int[3][3];
        //값대입
        int k=1;

        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=k;
                k++;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
