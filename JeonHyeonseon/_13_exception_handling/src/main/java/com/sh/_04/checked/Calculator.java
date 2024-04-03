package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public void sum() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true){
            try {
                System.out.print("정수1 입력 : ");
                int num1 = sc.nextInt();
                System.out.print("정수2 입력 : ");
                int num2 = sc.nextInt();
                sum = num1 + num2;
                System.out.println("결과 : " + sum);
            } catch(InputMismatchException e) {
                System.out.println("유효한 정수를 입력해주세요.");
                sc.next(); // 버퍼의 문자열 제거
            }
        }
    }
}
