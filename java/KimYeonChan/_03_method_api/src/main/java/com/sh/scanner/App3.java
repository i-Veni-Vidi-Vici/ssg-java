package com.sh.scanner;

import java.util.Scanner;

/**
 * next 메소드 다음에 nextLine 메소드를 사용하는 경우
 * - 입력버퍼에 남아있는 개행문자를 다음 nextLine 메소드가 읽어서 처리. 실제 입력값을 읽지 못함
 * - 개행문자를 제거용 nextLine 메소드를 미리 호출해야 한다.
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. next 메소드 사용
        System.out.print("> 이름 입력: "); // 개행 없이 입력 가능
        String name = sc.next();
        sc.nextLine();

        System.out.print("> 자기소개 입력: ");
        String greeting = sc.nextLine();

        System.out.println("> 이름: " + name);
        System.out.println("> 자기소개: " + greeting);
    }
}
