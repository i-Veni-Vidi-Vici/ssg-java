package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 입력할 정수 : ");
        int num = sc.nextInt();
        int sum = 0;

        for(int i = 2; i <= num; i++){
            if(i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("짝수들의 합 : " + sum);

    }
}
