package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void rockPaperScissors(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int select = 0;


        System.out.println("===가위 바위 보 게임===");
        System.out.println("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
        select = sc.nextInt();
        String user1;
        String com1;
        boolean flag = true;


        user1 = numToRCP(select);
        com1 = numToRCP(rnd.nextInt(3)+1);


        System.out.println("=========결과=========");
        System.out.println("당신은"+ user1 +"을 냈습니다.");
        System.out.println("컴퓨터는"+ com1 +"을 냈습니다.");
        System.out.println("=====================");

        if(com1.equals(user1)){
            System.out.println("비겼습니다 -_-");
            return;
        }else if(user1.equals("가위")){
            switch (com1){
                case "바위" :
                    flag = false;
                    break;
                case "보" :
                    flag = true;
                    break;
            }
        }else if(user1.equals("바위")){
            switch (com1){
                case "보" :
                    flag = false;
                    break;
                case "가위" :
                    flag = true;
                    break;
            }
        }else if(user1.equals("보")){
            switch (com1){
                case "가위" :
                    flag = false;
                    break;
                case "바위" :
                    flag = true;
                    break;
            }
        }


        if(flag){
            System.out.println("당신이 이겼습니다. ㅠㅠ");
        }else{
            System.out.println("컴퓨터가 이겼습니다. ^ㅇ^");
        }
    }

    public String numToRCP(int select){
        String result="";
        switch (select){
            case 1 :
                result = "가위";
                break;
            case 2
                    :
                result = "바위";
                break;
            case 3
                    :
                result = "보";
                break;


        }
        return result;
    }
}
