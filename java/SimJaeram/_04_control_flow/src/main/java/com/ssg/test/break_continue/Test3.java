package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int randNum, userNum, count = 0;

        // 1 ~ 100 사이의 난수 발생
        randNum = (int) (Math.random() * 100) + 1;

        while (true) {
            System.out.print("정수 입력 : ");
            userNum = sc.nextInt();
//            System.out.println(randNum);
            count++;

            // 난수와 정수 일치 여부 판별
            if (randNum < userNum) {
                System.out.println("발생한 난수가 입력하신 정수보다 작습니다.");
            } else if (randNum > userNum) {
                System.out.println("발생한 난수가 입력하신 정수보다 큽니다.");
            } else {
                System.out.printf("정답입니다. %d회만에 정답을 맞추셨습니다.\n", count);
                break;
            }
        }

    }
}
