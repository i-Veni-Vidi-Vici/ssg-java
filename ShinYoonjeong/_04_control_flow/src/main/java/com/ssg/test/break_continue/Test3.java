package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public void test(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int num=0;
        int rnum = rnd.nextInt(100)+1;
        int i=0;
        do {
            i++;
            System.out.println("정수를 입력하시오. => ");
            num = sc.nextInt();
            if(num>rnum)
            {
                System.out.println("입력하신 정수보다 작습니다.");
            }
            else
            {
                System.out.println("입력하신 정수보다 큽니다.");
            }

        } while(num != rnum);
        System.out.println("정답입니다." + i + "회 만에 정답을 맞추셨습니다.");
    }
}
