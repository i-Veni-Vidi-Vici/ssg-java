package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("홀수인 양의 정수를 하나 입력하세요 ==> ");
            int odd = sc.nextInt();
            if (odd % 2 == 0) {
                System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
                break;
            }
            int[] arr = new int[odd];
            for (int i = 0; i < arr.length ; i++) {
                if (i <= odd / 2){
                    arr[i] = i+1;
                    continue;
                }
                arr[i] = odd - i;
            }
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i != arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            break;
        }
        // 4 5 6
        // 3 2 1
    }
}
