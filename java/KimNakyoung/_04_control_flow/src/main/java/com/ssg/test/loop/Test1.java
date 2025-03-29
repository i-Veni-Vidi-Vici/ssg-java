package com.ssg.test.loop;

import java.util.Scanner;

/**
 * 요구사항 : 1부터 사용자로부터 입력 받은 정수까지 존재하는 짝수의 합을 출력하세요..
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(">정수 입력 :");
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }System.out.println(sum);
    }
}
