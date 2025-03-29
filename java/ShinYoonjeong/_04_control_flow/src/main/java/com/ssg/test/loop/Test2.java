package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오. : ");
        int num = sc.nextInt();
        for(int i = 1;i <= num;i++){
            if(i % 2 == 0){
                System.out.printf("박");
            }
            else
                System.out.printf("수");
        }

    }
}
