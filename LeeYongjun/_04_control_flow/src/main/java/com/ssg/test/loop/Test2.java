package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        String answer ="";
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력 : ");
        int num = sc.nextInt();

        for(int i = 1; i < num; i++){
            if(num % 2 == 0){
                answer += "수";
            }
            else if(num % 2 == 1){
                answer += "박";
            }
        }
        System.out.print(answer);
    }
}
