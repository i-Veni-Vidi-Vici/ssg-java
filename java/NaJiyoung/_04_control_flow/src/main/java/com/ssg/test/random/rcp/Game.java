package com.ssg.test.random.rcp;

import java.util.Scanner;
import java.util.Random;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("===가위 바위 보 게임===");
        System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
        int num = sc.nextInt();  // 숫자 선택
        System.out.println("========결과========");

        int computerNum = rnd.nextInt(3)+1;    // 컴퓨터의 1~3 사이의 랜덤 숫자
        String myChoice = "";   // 내가 선택한 가위바위보 글자
        String computerChoice = ""; // 컴퓨터가 선택한 가위바위보 글자
        String win =  "당신이 이겼습니다.ㅠ.ㅠ";
        String draw = "비겼습니다.ㅡ.ㅡ";
        String lose = "제가 이겼습니다.^.^";

        if(num == 1)
            myChoice = "가위";
        else if(num == 2)
            myChoice = "바위";
        else if(num == 3)
            myChoice = "보";
        else {
            System.out.println("잘못 입력 하셨습니다.  프로그램을 종료합니다.");
            return;
        }

        if(computerNum == 1)
            computerChoice = "가위";
        else if(computerNum == 2)
            computerChoice = "바위";
        else
            computerChoice = "보";


        System.out.println("당신은 " + myChoice + "를 냈습니다.");
        System.out.println("컴퓨터는 " + computerChoice + "를 냈습니다.");
        System.out.println("===================");

        /**
         * 내가 이긴 경우 (나-컴퓨터)
         * - 1<3 가위-보
         * - 2>1 바위-가위
         * - 3>2 보-바위
         *
         * 내가 비긴 경우 (나-컴퓨터)
         * - 1==1 가위-가위
         * - 2==2 바위-바위
         * - 3==3 보-보
         *
         * 내가 진 경우 (나-컴퓨터)
         * - 1<2 가위-바위
         * - 2<3 바위-보
         * - 3>1 보-가위
         */

        if((num==1 && computerNum==3) || (num==2 && computerNum==1) || (num==3 && computerNum==2))  // 내가 이긴 경우
            System.out.println(win);
        else if((num==computerNum)) // 비긴 경우
            System.out.println(draw);
        else    // 내가 진 경우
            System.out.println(lose);
    }
}
