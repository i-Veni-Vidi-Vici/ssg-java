package com.sgg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // 사용자로부터 1부터 입력 받은 정수까지 존재하는 짝수의 합을 출력하세요.

        // 사용자가 입력한 값이 짝수가 되도록 식을 만들기
        // 짝수가 될 수 있도록 만든 식 : num % 2 == 0
        // if문 사용 -> 왜 if문을 사용해야 하는지 제대로 파악하기..
        Scanner sc = new Scanner(System.in); // 사용자의 입력을 받음
        System.out.print("정수를 입력하세요 (1부터 가능) : ");
        int num = sc.nextInt(); // 사용자가 입력하는 값에 변수 선언
        int sum = 0; // 입력 받은 정수들의 합

        for(int i = 1; i < num; i++){ // i = 변하는 값
            if(i % 2 == 0){  // 짝수라면
                sum += i;
            }
        }
        System.out.println("짝수의 합 : " + sum);
    }
}
