package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수를 하나 입력하세요. => ");
        int a = sc.nextInt();
        System.out.print("> 다른 정수를 하나 입력하세요. => ");
        int b = sc.nextInt();

        int max = Math.max(a, b);
        int min = Math.min(a, b);


        int sum = 0;
        for (int i = min; i < max; i++){
            if (i % 2 != 0){
                sum += i;
            }
        }
        System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.\n", min, max, sum);
    }
}
