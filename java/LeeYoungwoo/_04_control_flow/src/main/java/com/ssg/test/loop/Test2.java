package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        // 문제 2.
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력 : ");
        int num = sc.nextInt();

        String str;
        for(int i = 1; i <= num; i++) {
//            System.out.print(i);
            if(i % 2 == 0) {
                str = "박";
            }
            else {
                str = "수";
            }
            System.out.print(str);
        }

    }
}


