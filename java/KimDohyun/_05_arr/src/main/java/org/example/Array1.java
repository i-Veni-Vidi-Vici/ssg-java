package org.example;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        int[] scores = new int[3];
        double avg = 0;
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 3; ++i){
            System.out.print("학생 "+ i +" 점수 입력 : ");
            scores[i] = scan.nextInt();
            avg += (double) scores[i];
        }
        System.out.println("학생 들의 평균 점수는"+ avg/scores.length +" 입니다.");
    }
}
