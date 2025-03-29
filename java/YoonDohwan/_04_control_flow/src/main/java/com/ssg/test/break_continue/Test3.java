package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int rnd = rd.nextInt(100) + 1;
        int count = 0;

        while (true) {
            System.out.println("정수를 입력하시오 : (1~100)");
            int num = sc.nextInt();
            count+=1;
            if(num>rnd){
            System.out.println("입력하신 정수보다 작습니다.");

            }
            else if(num<rnd){
                System.out.println("입력하신 정수보다 큽니다.");

            }
            else if(num==rnd){

                System.out.printf("정답입니다.%d 회 만에 정답을 맞추셨습니다.",count);
                break;
            }

        }



    }
}