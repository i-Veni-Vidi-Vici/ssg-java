package com.sgg.test.array.lotto;

import java.util.Random;

public class LottoApp {
    public void test(){
        Random rnd = new Random();
        int[] numbers = new int[6];
        int temp=0;


        for(int i=0;i<6;i++)
        {
            numbers[i]=rnd.nextInt(45)+1;
            for(int j=0;j<i;j++)
            {
                if(numbers[i]==numbers[j])
                    i--;
            }
        }
        for(int i=0;i<numbers.length;i++)
        {
            for(int j=0;j<numbers.length-i-1;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    temp=numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }

        }


        for(int i = 0; i < numbers.length; i++)
        {

                System.out.print(numbers[i] + " ");


        }System.out.println();
    }
}

