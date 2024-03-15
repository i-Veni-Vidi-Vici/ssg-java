package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수입력 : ");
        int num = sc.nextInt();

        for(int i = 1; i <= 9; i++){
            if(num > 10){
                System.out.println("잘못입력하셨습니다. 프로그램 종료합니다.");
            }
            System.out.printf("%d * %d = %d\n",num,i,num * i);
        }
    }
}
