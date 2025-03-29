package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test();
    }

    private void test() {
        int random = (int)(Math.random()*100) + 1;
        Scanner sc = new Scanner(System.in);
        int sum = 1;

        again:
        for (;;){
            System.out.println("정수를 하나 입력하세요. => ");
            int input = sc.nextInt();
            if (input > random) {
                System.out.println("입력하신 정수보다 작습니다.");
                sum += 1;
                continue again;
            } else if (input < random) {
                System.out.println("입력하신 정수보다 큽니다.");
                sum += 1;
                continue again;
            } else {
                System.out.printf("정답입니다. %d회 만에 정답을 맞추셨습니다.", sum);
                break ;
            }
        }
    }
}