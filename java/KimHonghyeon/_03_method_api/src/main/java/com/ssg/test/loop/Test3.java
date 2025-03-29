package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("단수입력: ");
        int dan = scanner.nextInt();
        if(dan>9 || dan<1){
            System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
        }
        else{
            System.out.println("----"+dan+"단----");
            for(int n=1; n<=9; n++){
                System.out.printf("%d * %d = %d\n", dan, n, dan*n);

            }
        }
    }
}
