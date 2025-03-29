package com.ssg.test.multi.dimentional.array.test;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        MultiDimentionalArray mDA = new MultiDimentionalArray();
//        mDA.test1();  // 문제1
//        mDA.test2();    // 문제2
//        mDA.test3();    // 문제3
        mDA.test4();    // 문제4
    }

    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 문제1
    public void test1() {
        int[][] arr = new int[4][4];
        int n = 1;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++)
                arr[i][j] = n++;
        }
        print(arr);
    }

    // 문제2
    public void test2() {
        int[][] arr = new int[4][4];
        int n = 0;
        for(int i=0; i<arr.length; i++) {
            n = i+1;
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = n;
                n += 4;
            }
        }
        print(arr);
    }

    // 문제3
    public void test3() {
        int[][] arr = new int[4][4];
        int n = 0;
        for(int i=0; i<arr.length; i++) {
            n = 4*(i+1);
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = n;
                n--;
            }
        }
        print(arr);
    }

    // 문제4
    public void test4() {
        int[][] arr = new int[4][4];
        int n = 0;
        for(int i=0; i<arr.length; i++) {
            n = 16 - i;
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = n;
                n -= 4;
            }
        }
        print(arr);
    }
}
