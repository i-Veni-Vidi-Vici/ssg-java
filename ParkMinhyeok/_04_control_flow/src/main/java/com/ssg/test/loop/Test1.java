package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요: ");
        int num = sc.nextInt();
        int result = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0)
                result += i;
        }
        System.out.println(result);
    }
}
