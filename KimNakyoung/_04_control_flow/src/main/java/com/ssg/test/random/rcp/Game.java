package com.ssg.test.random.rcp;


import java.util.Random;
import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===가위 바위 보 게임===");
        System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보) : ");
        char num = sc.next().charAt(0);
        String user = "";
        String computer = "";
        Random rnd = new Random();
        int computerRandom = rnd.nextInt(3) + 1; // 컴퓨터 (1~3) 생성
//        System.out.println(computerRandom);


        switch (num) {
            case '1' : user = "가위"; break;
            case '2' : user = "바위"; break;
            case '3' : user = "보"; break;
            default:
                System.out.println("잘 못 입력했습니다.");
        }

        switch (computerRandom) {
            case 1 : computer = "가위"; break;
            case 2 : computer = "바위"; break;
            case 3 : computer = "보"; break;
            default:
                System.out.println("잘 못 입력했습니다.");
        }

        System.out.println("========= 결과 ===========");
        System.out.println("당신은 " + user + "를 " + "냈습니다." );
        System.out.println("컴퓨터는 " + computer + "를 " + "냈습니다." );
        System.out.println("==========================");

        if (((int) num == '1' && computerRandom == 3) ||
                ((int) num == '2' && computerRandom == 1) ||
                ((int) num == '3' && computerRandom == 2)) {
            System.out.println("당신이 이겼습니다. ㅠ.ㅠ");
        }
        else if ((int) num == computerRandom){
                System.out.println("둘다 비겼습니다");
        }else {
            System.out.println("컴퓨터가 이겼습니다.");
        }

    }
}
