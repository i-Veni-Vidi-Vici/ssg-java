package com.ssg.test.array;


import java.util.Scanner;

/**
 *
 * - 배열의 크기로 홀수인 양의 정수를 입력 받아 배열을 만드세요.
 * - 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
 * - 중간 이후부터 끝까지는 1씩 감소하ㅐ여 내림차순으로 값을 넣어 출력하는 프로그램을 작성하세요.
 */
public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.test();
    }
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의정수를 하나 입력하세요 ==> ");
        int num = sc.nextInt();
        if ( num > 0 && num % 2 != 0) {
            int[] arr = new int[num];// 홀수인 양의 정수 배열

            //1부터 증가 중간부터 감소
            int k = 1;
            for (int i = 0; i < num; i++) {
                arr[i] = k;
                if (i < num / 2) {
                    k++;
                } else {
                    k--;
                }
            }
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length - 1) {
                    System.out.print(arr[i] + ",");
                } else {
                    System.out.print(arr[i]);
                }

            }System.out.print("]");
        }
        else {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
        }

    }

}
