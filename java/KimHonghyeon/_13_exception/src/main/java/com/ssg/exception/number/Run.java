package com.ssg.exception.number;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test2();
    }
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("정수1 입력: ");
            int a = scanner.nextInt();
            System.out.print("정수2 입력: ");
            int b = scanner.nextInt();
            NumberProcess numberProcess = new NumberProcess();
            if(numberProcess.checkDouble(a,b)){
                System.out.println(a + "는" + b + "의 배수가 맞습니다.");
            }else{
                System.out.println(a + "는" + b + "의 배수가 아닙니다.");
            }
        }
        catch (NumberRangeException e){
            System.out.println(e.getMessage());
        }
    }
}
