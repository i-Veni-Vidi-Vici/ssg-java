package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberAgeChecker {
    public void checkAge() {
        // (나)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("> 나이 입력 : ");
//        int age  = sc.nextInt();
//        if (age < 20){
//            throw new RuntimeException("미성년자는 게임을 이용할 수 없습니다. : " + age);
//        } else {
//            System.out.println("🍸🍹🍺🍻");
//        }

        // (모범답안)
        Scanner sc = new Scanner(System.in);
        int age = 0;
        do {
            try{
                System.out.print("> 나이 입력 : ");
                age  = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("유효한 숫자를 입력하세요.");
                sc.next(); // 입력버퍼의 내용 비우기 (예외가 발생하면 버퍼의 내용을 제거하지 않음)
            }
        } while (age == 0);
        if (age < 20){
            throw new NotValidMemberAgeException(String.valueOf(age));
        }
    }
}
