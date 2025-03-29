package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("단수를 입력하세요 (1~9) : ");
        int num = sc.nextInt();

        if(num < 1 || num > 9){
            System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
        }
        else{
            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\n", num , i, num * i);
            }
        }
    }
}
