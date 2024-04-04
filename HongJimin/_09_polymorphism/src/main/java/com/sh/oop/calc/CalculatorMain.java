package com.sh.oop.calc;

import java.util.Scanner;

public class CalculatorMain {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        CalculatorMain main = new CalculatorMain();
        main.menu();
    }

    private void menu() {
        String menu = "계산기\n"
                + "================\n"
                + "1. 합\n"
                + "2. 차\n"
                + "3. 곱\n"
                + "4. 나누기\n"
                + "5. 나머지\n"
                + "0. 종료\n"
                + "---------------------\n"
                + "입력 : ";
        Calculator calculator = null;
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    new Adder().calc();
                    break;
                case "2":
                    new Substractor().calc();
                    break;
                case "3":
                    new Mulitplyer().calc();
                    break;
                case "4":
                    new Divider().calc();
                    break;
                case "5":
                    new Remainder().calc();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }

        }
    }
}
