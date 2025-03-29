package com.ssg.test.array;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("홀수인 양의정수를 하나 입력하세요 : ");
        int num = sc.nextInt();
        int[] arr = new int[num];

        if(num % 2 != 0){
            for(int i = 0; i < arr.length; i++){
                if((double)i <= (num / 2)) {
                    arr[i] = i + 1;
                }
                else {
                    arr[i] = num - i;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        else {
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다.");
        }
    }
}
