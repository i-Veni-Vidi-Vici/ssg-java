package com.sh._04.custom.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Caculator {

    public void sum() {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        while (true){

            try {
                System.out.println("첫 번째 정수 입력");
                num1 = scanner.nextInt();

                System.out.println("두 번째 정수 입력");
                num2 = scanner.nextInt();

                System.out.println("두 정수의 합은 = " + (num1 + num2) +"입니다");


            } catch (InputMismatchException e) {
                System.out.println("유효한 정수를 입력하세요");
                scanner.next();
            }
        }
    }

}
