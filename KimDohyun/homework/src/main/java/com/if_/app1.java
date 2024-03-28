package com.if_;

import java.util.Scanner;

public class app1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수 하나 입력하세요. => ");
        int n = scan.nextInt();
        int sum = 1;
        for(int i = 1; i < n; ++i){
            if(i%2 != 0)
                sum *= i;
        }
        System.out.println("1부터 "+n+"까지의 홀수의 곱은 "+sum+"입니다.");
    }
}
