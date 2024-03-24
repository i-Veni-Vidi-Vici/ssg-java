package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("홀수인 양의 정수를 하나 입력하세요 ==> ");
        int num = sc.nextInt();

        if(num % 2 ==1){
            int[]arr = new int[num];
            int tmp = 1;
            for(int i =0; i < num; i++){
                arr[i] = tmp;
                if(i < num / 2){
                    tmp++;
                }
                else{
                    tmp--;
                }
            }
            System.out.print("[");
            for(int i = 0; i<arr.length; i++){
                if(i < arr.length - 1){
                    System.out.print(arr[i] + ",");
                }
                else {
                    System.out.print(arr[i]);
                }
            }
            System.out.print("]");
        }
        else{
            System.out.println("잘못 입력했습니다, 홀수가 아닙니다.");
        }
    }
}
