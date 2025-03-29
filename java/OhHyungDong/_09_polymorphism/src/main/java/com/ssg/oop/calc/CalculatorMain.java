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
            int firstNumber;
            int secondNumber;
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.print("첫번째 수 입력 : ");
                    firstNumber = sc.nextInt();
                    System.out.print("두번째 수 입력 : ");
                    secondNumber =sc.nextInt();
                    calculator = new Adder(firstNumber,secondNumber);
                    calculator.calc(firstNumber,secondNumber);
                    break;
                case "2":
                    System.out.print("첫번째 수 입력 : ");
                    firstNumber = sc.nextInt();
                    System.out.print("두번째 수 입력 : ");
                    secondNumber =sc.nextInt();
                    calculator = new Substractor(firstNumber,secondNumber);
                    calculator.calc(firstNumber,secondNumber);
                    break;
                case "3":
                    System.out.print("첫번째 수 입력 : ");
                    firstNumber = sc.nextInt();
                    System.out.print("두번째 수 입력 : ");
                    secondNumber =sc.nextInt();
                    calculator = new Multiplyer(firstNumber,secondNumber);
                    calculator.calc(firstNumber,secondNumber);
                    break;
                case "4":
                    System.out.print("첫번째 수 입력 : ");
                    firstNumber = sc.nextInt();
                    System.out.print("두번째 수 입력 : ");
                    secondNumber =sc.nextInt();
                    calculator = new Divider(firstNumber,secondNumber);
                    calculator.calc(firstNumber,secondNumber);
                    break;
                case "5":
                    System.out.print("첫번째 수 입력 : ");
                    firstNumber = sc.nextInt();
                    System.out.print("두번째 수 입력 : ");
                    secondNumber =sc.nextInt();
                    calculator = new Remainder(firstNumber,secondNumber);
                    calculator.calc(firstNumber,secondNumber);
                    break;
                case "6":
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