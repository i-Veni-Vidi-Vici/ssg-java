package com.ssg.test.random.rcp;

import java.util.Scanner;
import java.util.Random;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        Random rnd=new Random();
        System.out.println("===가위 바위 보 게임===");
        System.out.print("숫자를 선택하세요 (1.가위 2.바위 3.보)");
        int num=sc.nextInt();
        int com=rnd.nextInt(3)+1;
        String player = " ";
        String computer = " ";
        System.out.println("===========결과=============");
        switch(num){
            case 1 : player = "가위";break;
                case 2: player = "바위";break;
            case 3: player = "보";break;
            default :
                System.out.println("오류입니다.");
                return;
        }
        switch(com){
            case 1 : computer = "가위";break;
            case 2: computer = "바위";break;
            case 3: computer = "보";break;
            default :
                System.out.println("오류입니다.");
                return;
        }

        System.out.println("당신은 " + player + "를 냈습니다.");
        System.out.println("컴퓨터는 " + computer + "를 냈습니다.");
        System.out.println("==============================");
        if(num==com){
            System.out.println("비겼습니다.");
        }
        else if(num==1&&com==2){
            System.out.println("졌습니다.");
        }
        else if(num==1&&com==3){
            System.out.println("이겼습니다.");
        }
        else if(num==2&&com==1){
            System.out.println("이겼습니다.");
        }
        else if(num==2&&com==3){
            System.out.println("졌습니다.");
        }
        else if(num==3&&com==1){
            System.out.println("졌습니다.");
        }
        else if(num==3&&com==2){
            System.out.println("이겼습니다.");
        }
        }

    }
