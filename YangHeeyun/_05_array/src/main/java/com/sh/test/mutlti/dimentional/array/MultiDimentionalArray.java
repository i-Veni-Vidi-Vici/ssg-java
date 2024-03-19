package com.sh.test.mutlti.dimentional.array;

public class MultiDimentionalArray {
    public static void main(String[] args){
        MultiDimentionalArray mda = new MultiDimentionalArray();
//        mda.test1();
//        mda.test2();
//        mda.test3();
       mda.test4();
    }

    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 문제1
     * 2차원 배열 `int[4][4]` 에 중첩 반복문을 사용해서 값대입 후 출력 하세요.
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     */
    public void test1(){
        int[][] arr = new int[4][4];
        int cnt=1;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = cnt++;
            }
        }
        print(arr);
    }

    /**
     * 문제2
     * 2차원 배열 `int[4][4]` 에 중첩 반복문을 사용해서 값대입 후 출력 하세요.
     * 1 5 9 13
     * 2 6 10 14
     * 3 7 11 15
     * 4 8 12 16
     */
    public void test2(){
        int[][] arr = new int[4][4];
        int num=1;
        for(int j=0;j<arr.length;j++){
            for(int i=0;i<arr.length;i++){
                arr[i][j] = num++;
            }
        }
        print(arr);
    }

    /**
     * 문제3
     * 2차원 배열 int[4][4] 에 중첩 반복문을 사용해서 값대입후 출력 하세요.
     * 4 3 2 1
     * 8 7 6 5
     * 12 11 10 9
     * 16 15 14 13
     */
    public void test3(){
        int[][] arr = new int[4][4];
        int num=1;
        for(int i=0;i<arr.length;i++){
            for(int j=arr.length-1;j>=0;j--){
                arr[i][j] = num++;
            }
        }
        print(arr);
    }

    /**
     * 문제4
     * 2차원 배열 int[4][4] 에 중첩 반복문을 사용해서 값대입후 출력 하세요.
     * 16 12 8 4
     * 15 11 7 3
     * 14 10 6 2
     * 13 9 5 1
     */

    public void test4(){
        int[][] arr = new int[4][4];
        int cnt =1;
        for(int j=arr.length-1; j>=0;j--){
            for(int i=arr.length-1;i>=0;i--){
                arr[i][j] = cnt++;
            }
        }
        print(arr);
    }
}
