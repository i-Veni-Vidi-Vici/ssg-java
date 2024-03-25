package com.ssg.oop.calc;

import java.util.Scanner;

public class CalculatorMain {

    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        CalculatorMain main = new CalculatorMain();
        main.menu();
    }

    private void menu() {

        String menu = "================\n"
                    + "계산기\n"
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

            int[] numbers;
            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    calculator = generateCalculator(choice);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }
            System.out.println("> 결과 : " + calculator.calc());
        }

    }

    /**
     * switch expression
     * - case값인 경우 해당하는 값을 반환.
     * - jdk12 부터 지원
     * @param choice
     * @return
     */
    private Calculator generateCalculator(String choice) {
        int[] numbers = inputNumbers();
        return switch(choice) {
            case "1" -> new Adder(numbers[0], numbers[1]);
            case "2" -> new Subtractor(numbers[0], numbers[1]);
            case "3" -> new Multiplyer(numbers[0], numbers[1]);
            case "4" -> new Divider(numbers[0], numbers[1]);
            case "5" -> new Remainder(numbers[0], numbers[1]);
            default -> null;
        };
    }

    private int[] inputNumbers() {
        int[] numbers = new int[2];
        System.out.print("> 정수1 입력 : ");
        numbers[0] = sc.nextInt();
        System.out.print("> 정수2 입력 : ");
        numbers[1] = sc.nextInt();
        return numbers;
    }
}
