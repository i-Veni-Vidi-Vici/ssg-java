package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 *     - next 메소드 (nextInt, nextDouble, nextBoolean)
 *     - 공백, 개행문자 전까지 읽어서 반환
 *
 *     - nextLine 메소드
 *     - 개행문자까지 포함하여 읽어서 개행문자 제거 후 반환
 * </pre>
 */

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주소 읽어오기
        System.out.println("주소 입력 : ");
//        String address = sc.next();               // 서울 서초구 역삼동 입력하더라도 서울까지만 읽음
        String address = sc.nextLine();             // 서울 서초구 방배동 입력하면 전부 읽음

        // 주소 출력하기
        System.out.println("> 입력한 주소는 [" + address + "]입니다.");

        sc.close();
    }
}
