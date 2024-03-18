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

        loop(lotto);
        System.out.println(Arrays.toString(lotto));
    }

    public void loop(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }else if(arr[i] == arr[j]) {
                    arr[i] = (int) (Math.random() * 45) + 1;
                    loop(arr);
                }else {
                    continue;
                }
            }
        }
    }
}
