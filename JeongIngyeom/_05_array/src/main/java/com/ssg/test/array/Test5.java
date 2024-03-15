package com.ssg.test.array;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("홀수인 양의 정수를 하나 입력하세요 ==> ");
            int odd = sc.nextInt();
            if (odd % 2 == 0) {
                System.out.println("잘못 입력했습니다. 홀수가 아닙니다.\n");
                continue;
            }

            int[] arr = new int[odd];
            for (int i = 0; i < arr.length; i++) {
                if(i < arr.length / 2) {
                    arr[i] = i + 1;
                }
                else
                    arr[i] = arr.length - i;
            }

            //System.out.println(Arrays.toString(arr));
            System.out.print('[');
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    System.out.print(arr[i]);
                    continue;
                }
                System.out.print(arr[i] + ", ");
            }
            System.out.print(']');
            break;
        }
    }
}
