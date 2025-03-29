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

            System.out.println("첫번째 정수를 입력하세요 :");
            int num1 = sc.nextInt();
            System.out.println("두번째 정수를 입력하세요 :");
            int num2 = sc.nextInt();
            calculator = new Adder(num1, num2);

            switch (choice) {
                case "1":   //합
                    calculator = new Adder(num1, num2);
                    calculator.calc();
                    break;
                case "2":   //차
                    calculator = new Subtractor(num1, num2);
                    calculator.calc();
                    break;
                case "3":   //곱
                    calculator = new Multiplyer(num1, num2);
                    calculator.calc();
                    break;
                case "4":   //나누기
                    calculator = new Divider(num1, num2);
                    calculator.calc();
                    break;
                case "5":   //나머지
                    calculator = new Remainder(num1, num2);
                    calculator.calc();
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