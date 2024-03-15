package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

/**
 * - 1~100 사이의 임의의 난수를 발생시키고, 정수 한 개를 입력 받습니다.
 - 난수가 입력 받은 정수보다 작으면 “입력하신 정수보다 작습니다.” 출력,
 - 난수가 입력 받은 정수보다 크면 “입력하신 정수보다 큽니다.” 출력하세요.
 - 단, 정답을 맞출 때까지 정수를 계속 입력 받아 프로그램이 반복되도록 하고,
 - 정답인 경우 **“정답입니다. 5회 만에 정답을 맞추셨습니다.”**와 같이
 몇 회 만에 정답을 맞추었는지 출력하도록 작성하세요.
 *
 */

public class Test3 {
    public static void main(String[] args) {
        int cnt = 0;
        Random rnd = new Random();
        int rndgen = rnd.nextInt(100)+1;
        Scanner sc = new Scanner(System.in);
        int input = 0;

        while(true){
            System.out.print("정수를 입력하세요 : ");
            input = sc.nextInt();
            cnt++;
            if (rndgen < input) {
                System.out.println("입력하신 정수보다 작습니다.");
            } else if (rndgen > input) {
                System.out.println("입력하신 정수보다 큽니다.");
            } else {
                System.out.println("정답입니다."+cnt+"회 만에 정답을 맞추셨습니다.");
                break;
            }
        }

    }
}
