package com.ssg.exception.number;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    public void test(){
        Scanner scanner = new Scanner(System.in);
        NumberProcess numberProcess = new NumberProcess();
        int n1;
        int n2;
        while(true){
            try{
                System.out.print("첫번째 수 입력 : ");
                n1 = scanner.nextInt();
                System.out.print("두번째 수 입력 : ");
                n2 = scanner.nextInt();
                boolean answer = numberProcess.checkDouble(n1, n2);
                if(answer) System.out.println(n1+"이 " +n2 +"의 배수입니다.");
                else System.out.println(n1+"이 " +n2 +"의 배수가 아닙니다.");
                break;
            }catch(NumberRangeException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

    }
}
