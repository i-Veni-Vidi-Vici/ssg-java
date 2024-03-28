package com.if_;

import java.util.Random;
import java.util.Scanner;

public class app3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int answer = rand.nextInt(101) ;
        Scanner scan = new Scanner(System.in);
        int cnt = 0;
        while (true) {
            cnt++;
            System.out.print("정수 하나 입력하세요. => ");
            int n = scan.nextInt();
            if(n > answer) System.out.println("입력하신 정수보다 작습니다");
            if(n < answer) System.out.println("입력하신 정수보다 큽니다");
            if(n == answer) {
                System.out.println("정답입니다." +cnt+"회만에 정답을 맞추셨습니다");
                break;
            }
        }
    }
}
