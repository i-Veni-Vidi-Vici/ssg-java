package com.ssg.test.multi.dimention.array;


/**
 *
 * 중첩반복문 & 다차원 배열
 *
 */
public class MultiDimentionalArray {

    public static void main (String[] args) {
        MultiDimentionalArray multiDimentionalArray = new MultiDimentionalArray();
//        multiDimentionalArray.test1();
//        multiDimentionalArray.test2();
//        multiDimentionalArray.test3();
        multiDimentionalArray.test4();
    }



    // 문제 2
    public void test2(){
        int[][] arr = new int[4][4];

        //행 0123 열 0 / 행 0123 열 1 / 행 0123 열 2 / 행 0123 열 3 이라 자리 바꿔줌
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[j][i] = k++;

            }
        }print(arr);

    }

    // 문제 3
    public void test3() {
        int[][] arr = new int[4][4];

        // 행 0123 열 3210
        int k =1;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = arr.length-1 ;  j >= 0 ; j-- ){
                arr[i][j] = k++;
            }

        }print(arr);
    }

    //문제 4

    public void test4() {
        int[][] arr = new int[4][4];

        // 행 0123 동안 열 3 고정 / 2 / 1 이라서 둘이 바꿔줌
        int k = 1;
        for (int i = arr.length-1 ;  i >=0 ; i--) {
            for (int j = arr.length-1; j >=0 ; j--) {
                arr[j][i] = k++;
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
