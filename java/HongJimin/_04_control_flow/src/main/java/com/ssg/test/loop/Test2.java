package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int userNum = sc.nextInt();
        int count = 1;

        while(count <= userNum) {
            if (count %2 !=0) {
                System.out.print("수");
            } else {
                System.out.print("박");
            }
            count++;
        }
    }
}
