package com.ssg.exception;

import java.util.Scanner;

public class Main {
    //24시간 기준, 45분- 알람
    public static void main(String[] args) {
        /**
         * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
         * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
         * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
         */
        Scanner sc = new Scanner(System.in);
        int max;
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        max=a;

        int money;

        if(b>max)
            max=b;
        if(c>max)
            max=c;

        if(a==b && b==c)
        {
            money=10000+a*1000;
            System.out.println(money);
            return;
        }
        if(a==b && b!=c) {
            System.out.println(1000+a*100);
            return;
        }
        else if(b==c && a!=b) {
            System.out.println(1000 + b * 100);
            return;
        }
        else if(a==c) {
            System.out.println(1000 + a * 100);
            return;
        }
        System.out.println(max*100);
    }
}
