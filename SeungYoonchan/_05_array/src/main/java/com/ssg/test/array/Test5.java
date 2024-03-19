package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 입력하시오 : ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
            return; //프로그램 종료
        }
        int[] arr = new int[num];

        int i = 0, count = 1;
        System.out.print("[ ");
        for (i = 0; i < num; i++) {
            arr[i] = count;
            if (i >= num / 2) {
                count--;
            }
            else{
                count ++;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}