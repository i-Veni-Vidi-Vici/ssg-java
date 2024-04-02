package com.sgg.exception.number;


import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=0, b=0;
        System.out.println("정수 1 입력 : ");
        a = sc.nextInt();
        System.out.println("정수 2 입력 : ");
        b = sc.nextInt();
        try{
            NumberProcess numberProcess = new NumberProcess();
            System.out.println(numberProcess.checkDouble(a, b));
            System.out.println("프로그램 정상 종료!");
        } catch (NumberRangeException e){
            System.out.println(e.getMessage());
        }

    }


}
