package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수 입력 : ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0) {
                System.out.print("박");
            } else {
                System.out.print("수");
            }
        }
    }
}
