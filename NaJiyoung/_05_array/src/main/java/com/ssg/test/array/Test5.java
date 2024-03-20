package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5. test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 하나 입력하세요 ==> ");
        int odd = sc.nextInt(); // 홀수인 양의 정수
        int[] arr = new int[odd];   // odd 크기의 배열

        if(odd%2 == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                if(i < odd/2)   // 배열 앞부분
                    arr[i] = i+1;
                else if(i == odd/2)
                    arr[i] = odd/2 + 1;
                else     // 배열 뒷부분
                    arr[i] = odd % i;   // 홀수에서 배열 인덱스를 나눈 나머지

                if(i!=arr.length-1) {
                    System.out.print(arr[i] + ", ");
                } else {
                    System.out.println(arr[i] + "]");
                }
            }
        } else {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return;
        }
    }
}
