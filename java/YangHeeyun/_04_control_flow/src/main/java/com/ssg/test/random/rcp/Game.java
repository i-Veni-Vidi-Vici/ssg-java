package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

/**
 * 가위바위보게임
 * 1. 사용자 가위/바위/보 입력
 * 2. 프로그램 가위/바위/보 결정(난수)
 * 3. 값 비교 & 결과출력
 */

public class Game {
    public void rockPaperScissors(){
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("===가위 바위 보 게임===");
        System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보) : ");

        // 내가 선택한 수
        int num = sc.nextInt();
        String me = "";

        if(num == 1){
            me = "가위";
        }else if(num == 2){
            me = "바위";
        }else if(num == 3){
            me = "보";
        }

        // 컴퓨터도 가위,바위,보 해야되니까 random으로 1~3까지 받고 출력문으로 가위바위보 구분
        // 컴퓨터에서 자동으로 선택한 수
        int randomNum = rnd.nextInt(3) + 1;
        String com = "";

        if(randomNum == 1){
            com = "가위";
        }else if(randomNum == 2){
            com = "바위";
        }else if(randomNum == 3){
            com = "보";
        }

        System.out.println("=======결과=======");
        System.out.println("당신은 " + me + "를 냈습니다.");
        System.out.println("컴퓨터는 " + com + "를 냈습니다.");

        System.out.println("=================");

        if ((num == 1 && randomNum == 1) || (num == 2 && randomNum == 2) || (num == 3 && randomNum == 3)){
            System.out.println("비겼습니다.");
        }else if ((num == 1 && randomNum == 2) || (num == 2 && randomNum == 3) || (num == 3 && randomNum == 1)){
            System.out.println("당신이 졌습니다!");
        }else if ((num == 1 && randomNum == 3) || (num == 2 && randomNum == 1) || (num == 3 && randomNum == 2)){
            System.out.println("당신이 이겼습니다.ㅠㅠ");
        }
    }
}
