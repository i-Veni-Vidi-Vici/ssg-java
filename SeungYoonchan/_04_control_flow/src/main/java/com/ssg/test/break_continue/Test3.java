package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd = (int) (Math.random() * 100) + 1;

        int cnt = 0; // 입력횟수
        System.out.println(rnd);
        while (true) {
            System.out.print("1에서 100사이의 정수를 입력하세요 ==> ");
            int num = sc.nextInt();

            cnt++;
            if (num > rnd) {
                System.out.println("입력하신 정수보다 작습니다.");
            } else if (num < rnd) {
                System.out.println("입력하신 정수보다 큽니다.");
            } else {
                System.out.println(cnt + "번만에 정답을 맞추셨습니다.");
                break;
            }
        }

    }
}