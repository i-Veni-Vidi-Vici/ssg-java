package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Random random = new Random();
        int rnd = random.nextInt(100)+1;
        Scanner sc = new Scanner(System.in);



        for(int i = 1; ; i++) {
            System.out.print("정수입력 : ");
            int num = sc.nextInt(); // 입력정수
            if (rnd < num) {
                System.out.println("입력하신 정수보다 작습니다.");

            } else if(rnd > num) {
                System.out.println("입력하신 정수보다 큽니다.");

            }else {
                System.out.println("정답입니다. " + i +"회 만에 정답을 맞추셨습니다.");
                break;
            }
        }
    }
}
