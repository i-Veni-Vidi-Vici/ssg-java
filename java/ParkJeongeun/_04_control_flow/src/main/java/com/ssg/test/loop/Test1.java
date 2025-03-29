package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 입력 : ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++){
            if (i % 2 != 0){
                continue;
            }
            sum += i;
        }
        System.out.println("> 짝수 합 : " + sum);
    }
}
