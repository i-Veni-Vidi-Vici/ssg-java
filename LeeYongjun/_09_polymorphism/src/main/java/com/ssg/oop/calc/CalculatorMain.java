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
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    calculator.getNum1() = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    calculator.getNum2() = sc.nextInt();
                    calculate(new Adder(calculator.getNum1(), calculator.getNum2()));
                    break;
                case "2":
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    calculator.getNum1() = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    calculator.getNum2() = sc.nextInt();
                    calculate(new Adder(calculator.getNum1(), calculator.getNum2()));
                    break;
                case "3":
                    calculate(new Multiplyer(calculator.getNum1(), calculator.getNum2()));
                    break;
                case "4":
                    calculate(new Divider(calculator.getNum1(), calculator.getNum2()));
                    break;
                case "5":
                    calculate(new Remainder(calculator.getNum1(), calculator.getNum2()));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }

        }
    }

    private void calculate(Calculator calculator) {
        calculator.calc();
    }
}
