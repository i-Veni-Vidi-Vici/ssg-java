package com.ssg;

import java.util.Scanner;

public class app8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] imp = new double[3];
        for(int i = 0; i < 2; ++i){
            imp[i] = scanner.nextInt();
        }
        System.out.println((imp[0] / ((imp[1]/100) * (imp[1]/100))));


    }
}
