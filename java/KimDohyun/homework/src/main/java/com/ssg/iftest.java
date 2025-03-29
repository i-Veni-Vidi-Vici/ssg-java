package com.ssg;

import java.util.Scanner;

public class iftest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a < 1 || a > 10) System.out.println("1~10사이의 정수를 입력 해야 합니다.");
        else if(a % 2 == 0) System.out.println("짝수");
    }
}
