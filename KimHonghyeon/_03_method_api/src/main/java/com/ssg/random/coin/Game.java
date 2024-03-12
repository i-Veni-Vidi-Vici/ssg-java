package com.ssg.random.coin;

import java.util.Scanner;

public class Game {
    public void flipCoin(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("====동전 앞뒤 맞추기====");
            System.out.println("숫자를 입력해주세요. 1:앞면 2:뒷면 3:그만하기");
            int choice = scanner.nextInt();
            if(choice==1 || choice == 2){
                if((int)(Math.random()*2)+1 == choice){
                    System.out.println("맞췄습니다!");
                }
                else{
                    System.out.println("틀렸습니다!");
                }
                System.out.println("=================");
            }
            else if(choice==3){
                System.out.println("게임을 종료합니다.");
                return;
            }
            else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
