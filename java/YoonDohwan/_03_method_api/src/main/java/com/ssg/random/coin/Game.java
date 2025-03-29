package com.ssg.random.coin;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void coinflip(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int coin = rnd.nextInt(2)+1;
        System.out.println("===동전 앞뒤 맞추기===");
        System.out.println("숫자를 입력해주세요(1.앞면 / 2.뒷면 : )");
        int num = sc.nextInt();
        System.out.println(coin==num?"맞췄습니다.^^":"땡! 틀렸습니다.");
        System.out.println("----------------------------->Restart");
    }
}
