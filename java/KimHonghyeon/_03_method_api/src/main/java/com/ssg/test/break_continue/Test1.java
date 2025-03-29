package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.printf("정수입력: ");
        int num = scanner.nextInt();
        int multiSum =1;
        for(int i = 1; i<=num; i++){
            if(i%2==1){multiSum*=i;}
        }
        System.out.printf("1부터 %d까지 홀수곱은 %d입니다.",num, multiSum);
    }
}
