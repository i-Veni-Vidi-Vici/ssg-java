package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private Scanner sc = new Scanner(System.in);
    public void sum() {
        int m = inputNumber(1);
        int n = inputNumber(2);
        System.out.println("결과 : " + (m + n));
    }

    private int inputNumber(int nth) {
        while (true) {
            try {
                System.out.print("정수 " + nth + " 입력 : ");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 정수를 입력하세요...");
                sc.next(); // 버퍼의 문자열 제거
            }
        }
    }
}
