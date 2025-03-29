package com.ssg.test.condition_if;

import java.util.Scanner;

public class Test2 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int num=0;
        System.out.println(">1~10사이의 정수를 입력하세요 : ");
        num= sc.nextInt();
        if (num<1 || 10<num){
            System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
            return;
        }
        switch (num%2){
            case 0 :
                System.out.println("짝수다.");
                break;
            case 1 :
                System.out.println("홀수다.");
                break;
            default :
                break;

        }


    }
}
