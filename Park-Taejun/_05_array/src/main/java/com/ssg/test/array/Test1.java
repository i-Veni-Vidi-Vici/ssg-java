package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args){

        int [] arr = new int[100];
        for(int i=0; i < arr.length; i++){ //자바에서 배열의 인덱스는 0부터 시작하기 때문임
            arr[i] = i +1;
        }
        for(int i = 0; i< arr.length;i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
