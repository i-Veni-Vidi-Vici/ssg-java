package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int num = 0; // 입력받은 정수
        int randomNum = rnd.nextInt(100) + 1;   // 1 ~ 100 사이의 난수
        int cnt = 0;    // 몇 회만에 정답을 맞추었는지

        do {
            System.out.print("정수를 하나 입력하세요. => ");
            num = sc.nextInt(); // 입력받은 정수
            cnt++;

            if (num > randomNum) {
                System.out.println("입력하신 정수보다 작습니다.");
                continue;
            } else if (num < randomNum) {
                System.out.println("입력하신 정수보다 큽니다.");
                continue;
            }
        } while( num != randomNum);
        System.out.println("정답입니다. " + cnt + "회 만에 정답을 맞추셨습니다.");
    }
}
