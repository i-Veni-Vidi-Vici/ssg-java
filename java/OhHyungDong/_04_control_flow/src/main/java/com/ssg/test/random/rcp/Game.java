package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void rockPaperScissors()
    {
        Scanner scan =new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("====가위바위보 게임====");
        System.out.print("숫자를 선택하세요(1. 가위 / 2.바위 / 3. 보) : ");
        int number = scan.nextInt();
        int computerNumber = rnd.nextInt(3) + 1;
        System.out.println("======결과======");

        switch (number)
        {
            case 1:  //사용자 : 가위
                if(computerNumber == 2) // 컴퓨터 : 바위
                {
                    System.out.println("당신은 가위를 냈습니다.");
                    System.out.println("컴퓨터는 바위를 냈습니다.");
                    System.out.println("당신이 졌습니다.");
                }
                else if(computerNumber == 3) //컴퓨터 : 보자기
                {
                    System.out.println("당신은 가위를 냈습니다.");
                    System.out.println("컴퓨터는 보를 냈습니다.");
                    System.out.println("당신이 이겼습니다.");
                }
                else { // 비김
                    System.out.println("당신은 가위를 냈습니다.");
                    System.out.println("컴퓨터는 가위를 냈습니다.");
                    System.out.println("비겼습니다.");
                }
                break;

            case 2:  //사용자 : 바위
                if(computerNumber == 1) // 컴퓨터 : 가위
                {
                    System.out.println("당신은 바위를 냈습니다.");
                    System.out.println("컴퓨터는 가위를 냈습니다.");
                    System.out.println("당신이 이겼습니다.ㅠㅠ");
                }
                else if(computerNumber == 3) //컴퓨터 : 보자기
                {
                    System.out.println("당신은 바위를 냈습니다.");
                    System.out.println("컴퓨터는 보자기를 냈습니다.");
                    System.out.println("당신이 졌습니다.");
                }
                else { // 비김
                    System.out.println("당신은 바위를 냈습니다.");
                    System.out.println("컴퓨터는 바위를 냈습니다.");
                    System.out.println("비겼습니다.");
                }
                break;

            case 3:  //사용자 : 보
                if(computerNumber == 2) // 컴퓨터 : 바위
                {
                    System.out.println("당신은 보자기를 냈습니다.");
                    System.out.println("컴퓨터는 바위를 냈습니다.");
                    System.out.println("당신이 이겼습니다.ㅠㅠ");
                }
                else if(computerNumber == 1) //컴퓨터 : 가위
                {
                    System.out.println("당신은 보자기를 냈습니다.");
                    System.out.println("컴퓨터는 가위를 냈습니다.");
                    System.out.println("당신이 졌습니다.");
                }
                else { // 비김
                    System.out.println("당신은 보자기를 냈습니다.");
                    System.out.println("컴퓨터는 보자기를 냈습니다.");
                    System.out.println("비겼습니다.");
                }

            default:
                break;
        }



    }
}
