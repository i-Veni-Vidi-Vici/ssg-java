package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("작은 정수 입력: ");
        int min = scanner.nextInt();
        System.out.printf("큰 정수 입력: ");
        int max = scanner.nextInt();
        int multiSum =1;
        for(int i = min; i<=max; i++){
            if(i%2==1){multiSum*=i;}
        }
        System.out.printf("%d부터 %d까지 홀수 곱은 %d입니다.", min, max, multiSum);
    }
}
