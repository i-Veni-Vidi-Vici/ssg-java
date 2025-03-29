package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public void flipCoin()
    {
        Random rnd = new Random();
        int num = rnd.nextInt(2) + 1;
        Scanner sc = new Scanner(System.in);
        int num2 = sc.nextInt();
        if(num==num2)
        {
            System.out.println("맞췄습니다.");
        }
    }

}
