package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            if(i%2!=0){
                System.out.print("수");
            }
            else{
                System.out.print("박");
            }
        }
    }
}
