package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberAgeChecker {
    public void checkAge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("나이 입력 : ");
        int age = 0;
        do{
            try{
                age=sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("유효한 숫자를 입력하세요.");
                sc.next(); // 입력 버퍼의 내용 비우기
            }
        }while(age == 0);
        if(age<20)
            throw new NotValidMemberAgeException(String.valueOf(age));
    }
}
