package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오. : ");
        int num = sc.nextInt();
        int sum = 0;
        for(int i = 1;i <= num;i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        System.out.println("짝수의 합은 : " + sum);

    }
}
