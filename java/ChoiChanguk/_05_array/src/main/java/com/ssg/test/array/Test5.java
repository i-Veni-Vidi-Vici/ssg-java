package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        int[] arr;
        int pivot;
        int cnt=1;

        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.printf("혹수인 양의정수를 하나 입력하세요 ==> ");
            pivot=sc.nextInt();

            if (pivot % 2 == 0) {

                System.out.printf("잘못 입력했습니다. 홀수가 아닙니다\n");
            } else {
                break;

            }
        }
        arr=new int[pivot];

        for (int i = 0; i < pivot / 2; i++) {

            arr[i] = cnt;
            cnt++;
        }

        for (int i = pivot/2; i < arr.length; i++) {

            arr[i] = cnt;
            cnt--;
        }


        for(int i=0;i<arr.length;i++) {
            System.out.printf("%d ",    arr[i]);
        }

    }
}
