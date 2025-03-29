package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private Scanner sc = new Scanner(System.in);
    public void sum() {
        boolean result = true;
        while (result) {
            System.out.println("두 정수를 입력하세요");
            try {
                System.out.print("정수1 입력 : ");
                int num1 = sc.nextInt();
                System.out.print("정수2 입력 : ");
                int num2 = sc.nextInt();
                System.out.print("결과 : ");
                System.out.println(num1 + num2);
                result = false; // flag ?
            } catch (InputMismatchException e) {
                System.out.println("유효한 정수를 입력해주세요.");
                sc.next();
            }
        }
        int m = inputNumber(1);
        int n = inputNumber(2);
        System.out.println("결과 : " + (m + n));
    }

    private int inputNumber(int nth) {
        while (true) {
            try {
                System.out.println("정수" + nth + "입력: ");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 정수를 입력하세요...");
                sc.next();
            }
        }
    }
}
