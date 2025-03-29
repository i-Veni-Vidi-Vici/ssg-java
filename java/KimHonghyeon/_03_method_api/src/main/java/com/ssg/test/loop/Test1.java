package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력해주세요: ");
        int num = scanner.nextInt();
        int sum =0;
        for(int i =2; i<=num; i+=2){
            sum+=i;
        }
        System.out.println( num+ "이하 짝수의 합은 " + sum + " 입니다.");
    }
}
