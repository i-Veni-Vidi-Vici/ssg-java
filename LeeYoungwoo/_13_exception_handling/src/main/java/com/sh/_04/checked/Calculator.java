package com.sh._04.checked;

import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);

    public void sum() {
        int num1 = inputNumber(1);
        int num2 = inputNumber(2);
        int sum = num1 + num2;

        System.out.println("결과 : " + sum);


    }

    private int inputNumber(int i) {
        while (true){
            try {
                System.out.print("정수1 입력 : ");
                return sc.nextInt();
            } catch (NumException e) {
                System.out.println("유효한 정수를 입력해주세요");
                sc.next();
            }
        }

    }
}
