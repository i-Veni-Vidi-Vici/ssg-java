package com.ssg.test.lotto;

import java.util.Arrays;

import static com.sh.array.sort.Swap.swap;

public class LottoApp {
    public static void main(String[] args) {
        // 랜덤 45개 중 6개 출력
        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length ; i++){
            int rnd = (int) (Math.random() * 45) + 1;
            lotto[i] = rnd;
        }

        for (int i = 0; i < lotto.length - 1; i++){
            for (int j = i + 1; i < lotto.length; j++){
                if (lotto[i] > lotto[j]){
                    swap(lotto, i, j);
                    System.out.print(lotto[i] + " ");
                }
            }
        }
    }
}
