package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public void sum(){
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        do{
            try{
                System.out.print("정수 2개를 입력해주세요: ");
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                System.out.println(A + " + " + B+ " = "+ (A+B));
                isValid=true;

            }
            catch(InputMismatchException e){
                System.out.println("유효한 정수를 입력해주세요.");
                scanner.nextLine();
            }
        }while (!isValid);
    }
}
