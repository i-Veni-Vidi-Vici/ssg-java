package com.if_;

import java.util.Scanner;

public class app2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수 하나 입력하세요. => ");
        int n = scan.nextInt();
        System.out.print("다른 정수 하나 입력하세요. => ");
        int n2 = scan.nextInt();
        int sum = 0;
        int end = 0;
        int i = 0;

        if(n > n2) {
            end = n;
            i = n2;
        }
        else if(n2 > n){
            end = n2;
            i = n;
        }
        else {
            end = n;
            i = n;
        }
        int tempi = i;
        for(; i < end; ++i){
            if(i%2 != 0)
                sum += i;
        }
        System.out.println(tempi+"부터 "+end+"까지의 홀수의 합은 "+sum+"입니다.");

    }
}
