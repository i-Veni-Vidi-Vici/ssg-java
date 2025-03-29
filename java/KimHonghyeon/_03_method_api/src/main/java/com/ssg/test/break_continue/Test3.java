package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        int ans = (int)(Math.random()*100)+1;
        Scanner scanner = new Scanner(System.in);

        int tryCount =0;
        int inputAns =-1;
        do{
            System.out.print("정답을 입력하세요: ");
            inputAns = scanner.nextInt();
            tryCount++;
            if(inputAns==ans){
                System.out.println("정답입니다. "+ tryCount+"회 만에 맞추셨습니다.");
                break;
            }
            else if(inputAns> ans){
                System.out.println("틀렸습니다. 입력하신 값이 정답보다 큽니다.");
            }
            else{
                System.out.println("틀렸습니다. 입력하신 값이 정답보다 작습니다.");
            }
        }while(true);
    }
}
