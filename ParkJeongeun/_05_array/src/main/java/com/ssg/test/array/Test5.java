package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 홀수인 양의 정수를 하나 입력하세요 ==> ");
        int odd = sc.nextInt();

        if (odd % 2 == 0){
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return;
        }

        int[] arr = new int[odd];
        int k = 1;
        for (int i = 0; i < arr.length; i++){
            if (i < arr.length/2 + 1) {
                if (i == 0) {
                    arr[i] = k++;
                    System.out.print("[" + arr[i] + ", ");
                    continue;
                }
                arr[i] = k++;
                System.out.print(arr[i] + ", ");
            } else {
                if (i == arr.length - 1){
                    arr[i] = arr[i-1] - 1;
                    System.out.println(arr[i] + "]");
                    break;
                }
                arr[i] = arr[i-1] - 1;
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
