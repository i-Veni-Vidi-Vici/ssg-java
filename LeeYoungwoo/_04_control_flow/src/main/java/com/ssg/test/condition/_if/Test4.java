package com.ssg.test.condition._if;

import java.util.Random;
import java.util.Scanner;

public class Test4 {
    public void test() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        // 컴퓨터가 선택한 숫자 생성
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0; // 시도 횟수 초기화

        System.out.println("컴퓨터가 숫자를 선택했습니다. 1에서 100 사이의 숫자를 맞춰보세요.");

        int guess;
        do {
            System.out.print("숫자를 입력하세요: ");
            guess = sc.nextInt();
            attempts++; // 시도 횟수 증가

            if (guess < randomNumber) {
                System.out.println("Up");
            } else if (guess > randomNumber) {
                System.out.println("Down");
            } else {
                System.out.println("정답입니다! 컴퓨터가 선택한 숫자는 " + randomNumber + "입니다.");
                System.out.println("축하합니다! 시도한 횟수는 " + attempts + "번 입니다.");
            }
        } while (guess != randomNumber);

        sc.close();
    }

}

