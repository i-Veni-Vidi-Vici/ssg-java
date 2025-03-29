package com.ssg.random.coin;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin(){
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        int tmprnd = 0;
        int answer = 0;
        String state = new String();
        state = "restart";

        while(state.equals("restart")){

            System.out.println("===동전 앞 뒤 맞추기===");
            System.out.println("숫자를 입력 해주세요 1.앞면 / 2.뒷면");
            tmprnd = (rnd.nextInt(2)+1);    //랜덤 넘버 생성
            answer = in.nextInt();  //정답 입력
            //입력 받은 수가 1이나 2면 실행
            if(answer==tmprnd){
                //앞면
                System.out.println("맞췄습니다^^");

            }else if(answer!=tmprnd){
                //뒷면
                System.out.println("땡! 틀렸습니다!");
            }
            System.out.println("-------------->");
            in.nextLine();
            state = in.nextLine();
            /*
            System.out.println("입력문자는:"+state);
            if(state=="restart"){
                System.out.println("재시작합니다");


            }*/
        }

    }
}
