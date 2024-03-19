package com.ssg.test.lotto;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;

public class LottoApp {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length; i++) {
            int num = (int) (Math.random() * 45) + 1;
            if (!duplication(num, lotto)) {
                lotto[i] = num;
            }
        }
        ascending(lotto);
        print(lotto);
    }

    public static boolean duplication(int num, int[] lotto) {
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] ascending(int[] lotto) {
        for (int i = 1; i < lotto.length; i++) {
            int temp = lotto[i];
            int j;
            for (j = i; j > 0; j--) {
                if (lotto[j - 1] > temp) {
                    lotto[j] = lotto[j - 1];
                } else {
                    break;
                }
            }
            lotto[j] = temp;
        }
        return lotto;
    }

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
