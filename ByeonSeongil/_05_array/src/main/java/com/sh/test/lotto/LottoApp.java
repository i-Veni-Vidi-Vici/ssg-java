package com.sh.test.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoApp {
    // 1~ 45번 6개

    public void test() {
        Random random = new Random();
        int[] lotto = new int[6];
        int index =0;

        outer:
        while (index !=6) {
            int number = random.nextInt(45)+1;
            for (int i = 0; i < lotto.length; i++) {
                if(lotto[i] == number){
                    continue outer;
                }
            }

            lotto[index++] = number;
        }

        for (int i = 0; i < lotto.length; i++) {
            for (int j = i+1; j < lotto.length; j++) {
                if (lotto[i] > lotto[j]) {
                    int temp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(lotto));

    }
}
