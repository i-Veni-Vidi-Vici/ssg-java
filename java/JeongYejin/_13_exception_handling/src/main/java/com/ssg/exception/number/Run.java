package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }
    public void test() {
        NumberProcess numberProcess = new NumberProcess();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        try {
            if (numberProcess.checkDouble(a, b)) {
                System.out.printf("%d의 배수이다", b);
            } else System.out.printf("%d의 배수가 아니다", b);
        } catch (NumberRangeException e) {
            e.printStackTrace();
        }
    }
}
