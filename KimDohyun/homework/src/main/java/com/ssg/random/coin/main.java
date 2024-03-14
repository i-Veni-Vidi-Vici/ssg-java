package com.ssg.random.coin;
import com.ssg.random.coin.Game;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("====동전 앞 뒤 맟추기=====");
            System.out.print("숫자를 입려하세요 (1앞면,2뒷면) :");
            int a = sc.nextInt();
            Game g = new Game();
            g.flipCoin(a);
        }
    }
}
