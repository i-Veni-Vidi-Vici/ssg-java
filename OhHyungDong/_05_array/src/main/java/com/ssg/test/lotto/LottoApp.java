package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoApp {
    public static void main(String[] args) {

        Random rnd = new Random();
        int[] rand = new int[6];

        for(int i = 0; i<rand.length; i++)
        {
            rand[i] = rnd.nextInt(45) + 1; // 1-45 랜덤 6개 뽑기

            for(int j = 0; j<i; j++)
            {
                if(rand[i] == rand[j]) i--; //값이 같은게 있으면 다시 뽑기
            }
        }

        Arrays.sort(rand);
        System.out.print("로또 번호 : ");
        for(int i = 0; i<rand.length; i ++)
        {
            System.out.print(rand[i] + " ");
        }
    }
}
