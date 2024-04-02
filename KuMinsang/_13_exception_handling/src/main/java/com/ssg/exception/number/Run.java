package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Run run1 = new Run();
        run1.test();
    }
    public void test(){
        NumberProcess numberProcess = new NumberProcess();
        int num1=0;
        int num2=0;
        System.out.println("2개의 정수를 입력하세요");
        System.out.print("첫번째 정수: ");
        num1 = sc.nextInt();
        System.out.print("두번째 정수: ");
        num2 = sc.nextInt();

        try {
            System.out.println(numberProcess.checkDouble(num1, num2) ? num2 + "의 배수이다" : num2 + "의 배수가 아니다");
        } catch(NumberRangeException e){
            System.out.println(e.getMessage());
        }
    }
}
