package com.sh.test.multi.dimentional.array;
public class Test1 {
    public void test1(){
        int[][] arr = new int[4][4];
        int value=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=value+1;
                value++;
            }
        }
        System.out.println();
        print(arr);

    }
    public void test2(){
        int[][]arr = new int[4][4];
        int value =0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[j][i]=value+1;
                value++;
            }

        }
        print(arr);
        System.out.println();
    }

        public void print(int[][] arr){
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

