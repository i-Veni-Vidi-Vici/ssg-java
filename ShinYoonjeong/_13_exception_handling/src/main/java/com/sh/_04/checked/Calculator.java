package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public int sum() {
        Scanner sc = new Scanner(System.in);
        int a=0,b=0;
        do{
            try{
                System.out.println("정수 1 입력 : ");
                a=sc.nextInt();
                System.out.println("정수 2 입력 : ");
                b=sc.nextInt();

            }catch (InputMismatchException e){
                System.out.println("유효한 숫자를 입력하세요.");
                sc.next(); // 입력 버퍼의 내용 비우기
                throw new NotValidNumber(String.valueOf(a+b));
            }
        }while(a == 0 && b == 0);
        return a+b;

    }
}
