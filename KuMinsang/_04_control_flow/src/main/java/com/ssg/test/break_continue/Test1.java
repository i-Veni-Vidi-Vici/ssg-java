package com.ssg.test.break_continue;

import java.util.Scanner;

/**
 *  1. 정수 한 개를 입력 받아, 1부터 입력 받은 정수까지의 홀수의 곱을 출력하세요.
    2. 출력예시
 *  정수를 하나 입력하세요. => 10
 *  1부터 10까지 홀수의 곱은 945입니다.
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input=0;
        int result =1;
        System.out.print("정수를 하나 입력하세요. => ");
        input = sc.nextInt();
        if(input == 0){
            return;
        }
        for(int i=0; i<input+1; i++){
            if((i+1) % 2 == 1){
                result *= i+1;
            }
        }
        System.out.println("1부터"+input+"까지 홀수의 곱은 "+result+"입니다.");
    }
}
