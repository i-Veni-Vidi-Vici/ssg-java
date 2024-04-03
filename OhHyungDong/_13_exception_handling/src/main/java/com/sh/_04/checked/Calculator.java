package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public void  sum(){
        Scanner scanner = new Scanner(System.in);
        int total= 0;

        while(true){
            try{
                System.out.println("첫번째 정수 : ");
                int n1 = scanner.nextInt();
                System.out.println("두번째 정수 : ");
                int n2 = scanner.nextInt();
                total = n1 + n2 ;
                System.out.println("두 정수의 합 : " + total);
                break;
            }catch(InputMismatchException e){
                System.out.println("올바른 수를 입력해주세요.");
                scanner.nextLine();
            }

        }

    }
}
