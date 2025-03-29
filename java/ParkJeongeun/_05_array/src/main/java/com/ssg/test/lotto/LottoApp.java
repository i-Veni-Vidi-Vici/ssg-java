package com.ssg.test.lotto;

import java.util.Arrays;

import static com.sh.array.sort.Swap.swap;

public class LottoApp {
    public static void main(String[] args) {
        // 랜덤 45개 중 6개 출력 (중복값X)
        int[] lotto = new int[6];
        int rnd;
        for (int i = 0; i < lotto.length ; i++){
            rnd = (int) (Math.random() * 45) + 1;
            if (i > 0){
                if (rnd == lotto[i - 1]){
                    do {
                        rnd = (int) (Math.random() * 45) + 1;
                    } while (rnd == lotto[i - 1]);
                    lotto [i] = rnd;
                    continue;
                }
            }
            lotto[i] = rnd;
        }

        for (int i = 0; i < lotto.length; i++){
            int min = i;
            for (int j = i + 1; j < lotto.length; j++){
                if (lotto[min] > lotto[j]){
                    min = j;
                }
            }
            swap(lotto, i, min);
        }
        System.out.println(Arrays.toString(lotto));


//        for (int i = 0; i < lotto.length - 1; i++){
//            for (int j = i + 1; i < lotto.length; j++){
//                if (lotto[i] > lotto[j]){
//                    swap(lotto, i, j);
//                    System.out.print(lotto[i] + " ");
//                }
//            }
//        }
    }
}
