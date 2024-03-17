package com.ssg;

import static java.lang.Math.pow;

public class lopp {
    public static void main(String[] args) {

        for(int i = 1; i <= 9; ++i){
            int n = i;
            int sum = 0;
            for(int j = 0; j <= i; ++j){
                sum += (int)pow(10.0,n--) * j;
            }
            System.out.printf("%9d",sum);
            System.out.println(" x 8 "+ " + "+i+" = "+((sum * 8) +i));

        }

    }
}
