package com.ssg;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        if(n % 2 == 0) {
            System.out.println("잘못된 숫자입니다");
            return;
        }
        int cnt = 0;

        for(int i = 0; i < n; ++i){
            if(i <= n/2) System.out.print(++cnt);
            else System.out.print(--cnt);
            System.out.print(" ");
        }
    }
}
