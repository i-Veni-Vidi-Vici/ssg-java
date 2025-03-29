package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberAgeChecker {
    public void checkAge() {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        do {
            try {
                System.out.print("성인인증이 필요합니다. 나이를 입력하세요. : ");
                age = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력하세요...");
                sc.next(); // 입력 버퍼의 내용 비우기 - 예외가 발생하면 버퍼의 내용을 제거하지 않는다.
            }
        } while (age == 0);
        if (age < 20) {
            throw new OnlyAdultException("" + age);
        }
        System.out.println("즐겜하세요!");
    }
}