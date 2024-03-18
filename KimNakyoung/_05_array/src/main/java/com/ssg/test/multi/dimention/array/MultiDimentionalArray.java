package com.ssg.test.multi.dimention.array;


/**
 *
 * 중첩반복문 & 다차원 배열
 *
 */
public class MultiDimentionalArray {

    public static void main (String[] args) {
        MultiDimentionalArray multiDimentionalArray = new MultiDimentionalArray();
        multiDimentionalArray.test1();
    }

//    문제 1 . 2차원 배열 int[4][4] 에 중첩 반복문을 사용해서 값대입 후 출력 하세요.

    public void test1(){
        int[][] arr = new int[4][4];

        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = k++;

            }
        }print(arr);

    }


    // 출력메소드
    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
