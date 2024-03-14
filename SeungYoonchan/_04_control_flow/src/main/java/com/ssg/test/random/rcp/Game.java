package com.ssg.test.random.rcp;

import java.util.Scanner;

public class Game {
    public void rockPaperScissors(){
        Scanner sc = new Scanner(System.in);

        System.out.println("======== 가위바위보 게임 ========");
        System.out.print("숫자를 선택하세요 (1.가위 / 2.바위 / 3.보) : ");
        int user = sc.nextInt();

        int computer = (int)(Math.random()*3)+1; // 1~3 난수 생성
        char result = ' ';

        System.out.println("======== 결과 ========");
        switch (user) {
            case 1:
                System.out.println("당신은 가위를 냈습니다.");
                switch (computer) {
                    case 1:
                        System.out.println("컴퓨터는 가위를 냈습니다.");
                        result = 'D';
                        break;
                    case 2:
                        System.out.println("컴퓨터는 바위를 냈습니다.");
                        result = 'L';
                        break;
                    case 3:
                        System.out.println("컴퓨터는 보를 냈습니다.");
                        result = 'W';
                        break;
                    default:
                        System.out.println("정수 1, 2, 3 중에서 입력하시오. 프로그램을 종료합니다.");
                        break;
                }//case1 종료
                break;
            case 2:
                System.out.println("당신은 바위를 냈습니다.");
                switch (computer) {
                    case 1:
                        System.out.println("컴퓨터는 가위를 냈습니다.");
                        result = 'W';
                        break;
                    case 2:
                        System.out.println("컴퓨터는 바위를 냈습니다.");
                        result = 'D';
                        break;
                    case 3:
                        System.out.println("컴퓨터는 보를 냈습니다.");
                        result = 'L';
                        break;
                    default:
                        System.out.println("정수 1, 2, 3 중에서 입력하시오. 프로그램을 종료합니다.");
                        break;
                }//case2 종료
                break;
            case 3:
                System.out.println("당신은 보를 냈습니다.");
                switch (computer) {
                    case 1:
                        System.out.println("컴퓨터는 가위를 냈습니다.");
                        result = 'L';
                        break;
                    case 2:
                        System.out.println("컴퓨터는 바위를 냈습니다.");
                        result = 'W';
                        break;
                    case 3:
                        System.out.println("컴퓨터는 보를 냈습니다.");
                        result = 'D';
                        break;
                    default:
                        System.out.println("정수 1, 2, 3 중에서 입력하시오. 프로그램을 종료합니다.");
                        break;
                }//case3 종료
                break;
        }//user switch-case문 종료

        System.out.println("=====================");
        switch (result){
            case 'W':
                System.out.println("당신이 이겼습니다.");
                break;
            case 'D':
                System.out.println("비겼습니다.");
                break;
            case 'L':
                System.out.println("당신이 졌습니다.");
                break;
        }

    }
}
