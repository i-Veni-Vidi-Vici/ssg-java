package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int i;

        for(i=0;i<100;i++)
        {
            arr[i]=i+1;
        }
        for(i=0;i<100;i++)
        {
            System.out.printf("%d ",arr[i]);
            if(i%30==0)
            {
                System.out.printf("\n"); // 너무 길어서 개행
            }
        }

    }
}
