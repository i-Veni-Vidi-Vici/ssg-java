package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int comNum = random.nextInt(1, 4);

        System.out.print("숫자를 입력하세요 (1. 가위 / 2. 바위 / 3. 보) : ");
        int userNum = sc.nextInt();

        String comWord = "";
        String userWord = "";

        String result = ""; // 승리 패배 결과

        switch (comNum) {
            case 1:
                comWord = "가위";
                break;
            case 2:
                comWord = "바위";
                break;
            case 3:
                comWord = "보";
                break;
        }

        switch (userNum) {
            case 1:
                userWord = "가위";
                break;
            case 2:
                userWord = "바위";
                break;
            case 3:
                userWord = "보";
                break;

        }

        if (userNum == comNum) {
            result = "비겼습니다🙂";
        }
        int minus = userNum - comNum; // 사용자가 선택한 수(num) - 컴퓨터가 랜덤추출한 수(randomNum) = -1 or 2인 경우 사용자가 짐 / -2 or 1인 경우 사용자가 이김

        if (minus == -1 || minus == 2) {
            result = "졌습니다😂";
        }
        if (minus == 1 || minus == -2) {
            result = "이겼습니다🥰졌습니다😂";
        }


        System.out.println("========결과========");
        System.out.println("당신은 ? " + userWord );
        System.out.println("컴퓨터는? " + comWord);
        System.out.println("====================");
        System.out.println("당신이 " + result);
    }
}
