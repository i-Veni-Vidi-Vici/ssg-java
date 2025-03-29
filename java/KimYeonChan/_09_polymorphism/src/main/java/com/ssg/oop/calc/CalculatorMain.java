package com.ssg.oop.calc;

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
                    calculator = new Adder();
                    break;
                case "2":
                    calculator = new Subtractor();
                    break;
                case "3":
                    calculator = new Multiplyer();
                    break;
                case "4":
                    calculator = new Divider();
                    break;
                case "5":
                    calculator = new Remainder();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }
            System.out.print("정수1 입력: ");
            calculator.setNum1(sc.nextInt());
            System.out.print("정수2 입력: ");
            calculator.setNum2(sc.nextInt());
            calculator.calc();
        }

    }
}