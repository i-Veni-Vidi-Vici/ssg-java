package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public void sum() {
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        do {
            try {
                System.out.print("첫번째 정수를 입력하세요 : ");
                num1 = sc.nextInt();
                System.out.print("두번째 정수를 입력하세요 : ");
                num2 = sc.nextInt();
                sum = num1 + num2;
                System.out.println("결과 : " + sum);
            } catch (InputMismatchException e) {
                System.out.println("유효한 정수를 입력해주세요");
                sc.next();
            }
        }
        while (sum == Integer.parseInt(null));
    }
}
