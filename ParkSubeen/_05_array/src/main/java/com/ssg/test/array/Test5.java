package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Test5 test = new Test5();
        test.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의정수를 하나 입력하세요 ==> ");
        int num = sc.nextInt();

        if(num % 2 == 0 && num <= 0) {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return;
        }

        int[] arr = new int[num];

        int k = 1;
        for(int i = 0; i < arr.length; i++) {
            if(i < arr.length / 2) {
                arr[i] = k++;
            } else{
                arr[i] = k--;
            }
            System.out.print(arr[i]);
        }
    }
}
