package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = 0;
        int input2 = 0;
        int big = 0;
        int small=0;
        int sum= 0;

        System.out.print("정수를 입력하세요 => ");
        input1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요 => ");
        input2 = sc.nextInt();
        if(input1>input2) {
            big = input1;
            small = input2;
        }
        else {
            big = input2;
            small = input1;
        }

        for(int i=small; i<=big; i++){
            if(i%2 == 0)
                continue;
            sum += i;
        }
        System.out.println(small+"부터 "+big+"까지의 홀수의 합은"+sum+"입니다");
    }
}
