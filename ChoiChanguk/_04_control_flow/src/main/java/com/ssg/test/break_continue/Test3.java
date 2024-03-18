package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int rnd=(int)(Math.random()*100)+1;

        System.out.printf("답을 입력해주세요");
        int num= sc.nextInt();

        int cnt=1;


        while(true)
        {
            if(num==rnd)
            {
                System.out.printf("정답입니다. %d회 만에 정답을 맞추셨습니다",cnt);
                break;
            }
            else {
                if(num<rnd)
                    System.out.printf("up\n");
                else
                    System.out.printf("down\n");

                System.out.printf("답을 입력해주세요 : ");
                num=sc.nextInt();
                cnt++;
            }
        }

    }
}
