package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoApp {
    public static void main(String[] args) {
        LottoApp test = new LottoApp();
        test.test6();
    }

    public void test6() {
        Random rnd = new Random();
        int[] lotto = new int[6];
        int temp = 0;

        for(int i = 0; i < lotto.length; i++) {
            lotto[i] = rnd.nextInt(45) + 1;
        }

        for(int i = 0; i < lotto.length - 1; i++) {
            for(int j = i + 1; j < lotto.length; j++) {
                if(lotto[i] > lotto[j]) {
                    temp = lotto[j];
                    lotto[j] = lotto[i];
                    lotto[i] = temp;
                }else if(lotto[i] == lotto[j]) {
                    lotto[i] = rnd.nextInt(45) + 1;
                }else {
                    continue;
                }
            }
        }
        System.out.println(Arrays.toString(lotto));
    }
}
