package com.sh.scanner;


import java.util.Scanner;

/**
 * <pre>
 * - next메소드 (nextInt, nexDouble, nextBoolean)
 * - 공백, 개행문자 전까지 읽어서 반환
 * - 이후 공백/개행문자는 입력버퍼에 남아있음
 * - nextLine메서도
 *  - 개행문자까지 읽어서 개행문자 제거후 반환
 * next메서드 다음에 nextLine메서드를 사용하는 경우
 * - 입력버퍼에 남아있는 개행문자를 다음 nextLine메서드가 읽어서 처리, 실제 입력값을 읽지 못함
 * - 개행문자 제거용 nextLine메서드를 미리 호출해야 함
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. next 메서드 사용
        System.out.println("> 이름 입력 : ");// 개행 없이 입력가능
        String name = sc.next();

//        sc.nextLine(); // 입력버퍼의 개행문자 제거용

        //  서초구 방배\n
        // 2. nextLine 메소드 서용
        System.out.println("> 자기소개 입력 :");
        String greeting = sc.nextLine();

        System.out.println("> 이름 : " + name);
        System.out.println("> 자기소개 : " + greeting);
    }
}
