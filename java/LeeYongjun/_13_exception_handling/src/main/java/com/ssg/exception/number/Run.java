package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        NumberProcess numberProcess = new NumberProcess();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("정수1 입력 : ");
            int a = sc.nextInt();
            System.out.print("정수2 입력 : ");
            int b = sc.nextInt();
            boolean result = numberProcess.checkDouble(a, b);
            if (result) {
                System.out.println(a + "은(는) " + b + "의 배수입니다.");
            } else {
                System.out.println(a + "은(는) " + b + "의 배수가 아닙니다.");
            }
        }
        catch (NumberRangeException e){
            System.out.println(e.getMessage());
        }

    }
}
