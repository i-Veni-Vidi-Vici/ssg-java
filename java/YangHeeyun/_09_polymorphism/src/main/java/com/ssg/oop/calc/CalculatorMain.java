package com.ssg.oop.calc;

import com.ssg.oop.calc.Calculator;

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
            System.out.print("첫번째 수 입력 > ");
            int num1 = sc.nextInt();
            System.out.print("두번째 수 입력 > ");
            int num2 = sc.nextInt();


            switch (choice) {
                case "1":
                    calculator = new Adder(num1,num2);
                    calculator.calc();
                    break;
                case "2":
                    calculator = new Subtractor(num1,num2);
                    calculator.calc();
                    break;
                case "3":
                    calculator = new Multiplyer(num1,num2);
                    calculator.calc();
                    break;
                case "4":
                    calculator = new Divider(num1,num2);
                    calculator.calc();
                    break;
                case "5":
                    calculator = new Remainder(num1,num2);
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