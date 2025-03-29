package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberAgeChecker {
    public void checkAge(){
        Scanner scanner = new Scanner(System.in);
        int age = -1;
        do {
            try{
                System.out.print("나이를 입력하세요: ");
                age = scanner.nextInt();

            }
            catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다.");
                scanner.next();
            }
        }while(age<0);
        if(age<20)throw new AgeException("미성년자는 게임을 이용할 수 없습니다. 현재 나이: "+age);
    }

}

class AgeException extends RuntimeException{
    AgeException(){
        super();
    }
    AgeException(String msg){
        super(msg);
    }

}
