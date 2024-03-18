package com.sh.multi.dimention;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int cnt = 1;
        System.out.println("행수 입력 : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][];
        for(int i = 0; i < n; ++i){
            arr[i] = new int[i+1];
            for(int j = 0; j < i+1; ++j){
                arr[i][j] = cnt++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
