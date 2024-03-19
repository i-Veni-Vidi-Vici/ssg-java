package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("정수를 입력하시오 : ");
        int sum=0;
        int num = sc.nextInt();
        for(int i=0;i<=num;i++){
            if(i%2==0){
                sum+=i;
            }

        }
        System.out.println(sum);
    }
}
