package com.ssg;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; ++i){
            if(i <= n/2) System.out.print(++cnt);
            else System.out.println(--cnt);
            System.out.println();
        }
    }
}
