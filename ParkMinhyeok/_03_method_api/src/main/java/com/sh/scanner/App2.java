package com.sh.scanner;

import java.util.Scanner;

/**
 * <ptr>
 * - next 메소드 ( nextInt, nextDouble, nextBoolean)
 * - 공백, 개행문자 전까지 읽어서 반환
 *
 * - nextLine
 * - 개행문자 포함
 * </ptr>
 */
public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주소 읽어오기
        System.out.println("주소 입력 : ");
        String adress = sc.next();

        System.out.println("> 입력한 주소는 [" + adress + "] 입니다.");
    }
}
