package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public void sum() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("정수입력1: ");
                int num1 = sc.nextInt();
                System.out.print("정수입력2: ");
                int num2 = sc.nextInt();
                System.out.println("결과: " + (num1 + num2));
                break;
            } catch (InputMismatchException e) {
                System.out.println("유효한 정수를 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
