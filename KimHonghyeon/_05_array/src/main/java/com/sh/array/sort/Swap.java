package com.sh.array.sort;


/**
 * - 변수의 값 교환
 * - 배열요소의 값 교환
 */
public class Swap {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void test1(){
        int a = 10;
        int b = 20;
        int temp =b;
        b=a;
        a=temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public void test2(){
        int[] arr ={1,2,4,3,5};
        /*
        int temp = arr[3];
        arr[3] = arr[2];
        arr[2] = temp;
        */
        swap(arr, 2,3);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for(int i=0; i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
