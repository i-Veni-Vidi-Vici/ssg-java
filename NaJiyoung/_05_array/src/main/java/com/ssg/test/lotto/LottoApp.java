package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;

import static com.sh.array.sort.Swap.swap;

public class LottoApp {
    public static void main(String[] args) {
        LottoApp lotto = new LottoApp();
        lotto.test();
    }

    /**
     * 로또 방법
     * - 45개의 번호 중 6개 번호 고르기
     */
    public void test() {
        Random rnd = new Random();
        int num = 0;    // 1~45 난수
        int[] lotto = new int[6];   // 중복 없는 6개 번호 배열
        int index = 0;  // 배열 인덱스

        abc:
        while(true) {
            num = rnd.nextInt(45) + 1;

            // 중복 있는 경우
            for(int i=0; i<index; i++) {
                if(lotto[i] == num)
                    continue abc;
            }

            // 중복 없는 경우
            lotto[index] = num;
            index++;

            if(index == lotto.length)
                break;
        }

        for(int j=0; j<lotto.length-1; j++) {
            for(int k=j+1; k<lotto.length; k++) {
                if(lotto[j]>lotto[k])
                    swap(lotto, j, k);
            }
        }
        System.out.print(Arrays.toString(lotto));
    }
}
