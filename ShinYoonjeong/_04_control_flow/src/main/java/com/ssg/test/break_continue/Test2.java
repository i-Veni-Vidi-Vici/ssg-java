package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int plus=0;
        System.out.println("정수를 하나 입력하시오. => ");
        int num1 = sc.nextInt();
        System.out.println("다른 정수를 입력하시오. => ");
        int num2 = sc.nextInt();
        if(num1>num2)
        {
            for(int i = num2;i < num1;i++){
                if(i%2==1){
                    plus+=i;
                }
            }
            System.out.println(num2 + "부터 " + num1 + "까지의 합은 " + plus + "입니다.");
        }
        else{
            for(int i = num1;i < num2;i++){
                if(i%2==1){
                    plus+=i;
                }

            }
            System.out.println(num1 + "부터 " + num2 + "까지의 합은 " + plus + "입니다.");
        }

    }
}
