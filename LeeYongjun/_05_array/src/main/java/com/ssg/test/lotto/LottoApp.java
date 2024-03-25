package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoApp {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[]lotto = new int[6];
        int index = 0;

        while (index < lotto.length){
            int num = rnd.nextInt(45) + 1;
            boolean duplication = false;

            for(int i = 0; i < index; i++){
                if(lotto[i] == num){
                    duplication = true;
                    break;
                }
            }
            if(!duplication){
                lotto[index] = num;
                index++;
            }
        }
        Arrays.sort(lotto);
        for(int i = 0; i < lotto.length; i++){
            System.out.print(lotto[i] + " ");
        }
    }
}
