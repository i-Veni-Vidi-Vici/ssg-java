package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력해주세요: ");
        int num = scanner.nextInt();
        for(int i =1; i<=num; i++){
            if(i%2==1){System.out.printf("수");}
            else{{System.out.printf("박");}}
        }
    }
}
