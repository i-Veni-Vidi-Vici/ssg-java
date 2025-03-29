package com.sh._04.checked;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private Scanner sc = new Scanner(System.in);

    public void sum() {

        inputNumber(1);
        int m = sc.nextInt();
        inputNumber(2);
        int n = sc.nextInt();
        System.out.println("결과 : " + (m + n));

    }


    private int inputNumber(int num) {
        while (true) {

            try {
                System.out.println("정수" + num + "입력");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유요한 정수 입력");
                sc.next();
            }
        }
    }

}
