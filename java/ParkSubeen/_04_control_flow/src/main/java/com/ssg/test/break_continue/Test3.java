package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        int rndNum = rnd.nextInt(100) + 1;
        int cnt = 1;
        while(true) {
            System.out.print("> 정수 입력 : ");
            int num = sc.nextInt();
            if(num > rndNum) {
                System.out.println("입력하신 정수보다 작습니다.");
            }else if(num < rndNum) {
                System.out.println("입력하신 정수보다 큽니다.");
            }else {
                break;
            }
            cnt++;
        }
        System.out.println("정답입니다. " + cnt + "회 만에 정답을 맞추셨습니다.");

    }
}
