package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args){
        int[] arr = new int[100];

        int count = 0;
        for(int i=0;i<100;i++){
            arr[i] = i+1;
            if (count % 10 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + ", ");
            count++;
        }

    }
}
