package com.ssg.test.array;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {

        Test5 run = new Test5();
        run.test();

    }
    public void test(){
        int input=0;
        int[] arr;
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 하나 입력하세요 ==> ");
        input = sc.nextInt();
        if(input%2==0){
            System.out.println("잘못 입력했습니다. 홀수가 아닙니다");
            return;
        }

        int tmp=1;

        arr = new int[input];

        for(int i =0; i<input; i++){
            if(i<input/2){
                arr[i]=tmp++;
            }else{
                arr[i]=tmp--;
            }
        }

        for(int i=0; i<input; i++) {
            if (i == 0)
                System.out.print("[");
            System.out.print(arr[i]);
            if(i==input-1)
                System.out.println("]");
            else
                System.out.print(", ");
        }

    }
}
