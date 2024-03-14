package com.sh.scanner;

import java.util.Scanner;

/**
 * - next메소드 (nextInt, nextDouble, nextBoolean)
 * - 공백, 개행문자 전까지 읽어서 반환
 * - nextLine메소드( 공백 있으면 이거 쓰셈)
 * - 개행문자까지 읽어서 개행문자 제거후 반환
 *
 */


public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // alt + enter

        // 주소 읽어오기

        System.out.print("주소 입력 : ");
//        String address = sc.next();
        String address = sc.nextLine();


        System.out.println("> 입력한 주소는 [" + address + "]입니다."); // 서울 왜? next()쓰면 공백이나 개행문자 앞까지 !!



    }
}
