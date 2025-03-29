package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 => ");
        int num1 = sc.nextInt();
        System.out.print("다른 정수 하나를 입력하세요 =>");
        int num2 = sc.nextInt();
        int big=0;
        int small=0;
        if(num2>num1){
            big= num2;
            small=num1;
        }
        else{
            big=num1;
            small=num2;
        }
        int sum = 0;
        for(int i=small;i<big;i++){
            if(i%2==1){
                sum+=i;
            }
        }
        System.out.printf("%d부터 %d까지의 홀수의 합은 %d 입니다. ",small,big,sum);
    }
}
