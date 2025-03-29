package com.ssg.test.lotto;

import java.util.Arrays;

public class LottoApp {
    public static void main(String[] args) {
        int[] lottoNums = new int[6];
        
        int index = 0;
        add:
        while (index < lottoNums.length) {
            int rndNum = (int)(Math.random() * 45) + 1;
            for (int i = 0; i < index; i++) {
                if (lottoNums[i] == rndNum) {
                    continue add;
                }
            }
            lottoNums[index] = rndNum;
            index++;
        }

        for (int i = 0; i < lottoNums.length - 1; i++) {
            for (int j = i + 1; j < lottoNums.length; j++) {
                if (lottoNums[i] > lottoNums[j]) {
                    swap(lottoNums, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(lottoNums));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
