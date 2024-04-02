package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1: ");
        int num1 = sc.nextInt();
        System.out.print("숫자2: ");
        int num2 = sc.nextInt();
        NumberProcess np = new NumberProcess();

        try {
            System.out.println(num2+(np.checkDouble(num1, num2)?"의 배수이다": "배수가 아니다."));;
        } catch (NumberRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
