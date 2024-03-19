package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        int rndNum = rnd.nextInt(1, 101);
        int choice;
        int count = 0;

        do {
            System.out.println("> 정수입력 : ");
            choice = sc.nextInt();

            if(rndNum < choice) {
                System.out.println("입력하신 정수보다 작습니다.");
                count++;
            }
            else {
                System.out.println("입력하신 정수보다 큽니다.");
                count++;
            }
        }
        while (rndNum != choice);
        System.out.printf("정답입니다. %d회 만에 정답을 맞추셨습니다.", count);
    }
}
