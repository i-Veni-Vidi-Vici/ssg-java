package com.array;

import java.util.Arrays;
import java.util.Random;

public class app6 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] num = new int[6];
        for(int i = 0; i< 6; ++i){
            boolean flag = true;
            int n = rand.nextInt(45)+1;
            for(int j = 0; j < 6; ++j){
                if(n == num[j]) flag = false;
            }
            if(flag)
                num[i] = n;
            else i--;
        }
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }

}
