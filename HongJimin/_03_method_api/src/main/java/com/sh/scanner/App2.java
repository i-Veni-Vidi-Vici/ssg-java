package com.sh.scanner;

import java.util.Scanner;

/**
 *
 * next 메소드 - 공백, 개행 문자 전까지 읽어서 반환
 *
 * - 공백, 개행 문자 전까지 읽어서 반환
 * - 이후 공백 / 개햄 문자는 입력 버퍼에 남아 있음.
 *
 * nextLine 메소드
 * - 개행 문자까지 읽어서 개행 문자 제거 후 반환
 *
 *
 * - **next 메소드 다음에 nextLine 메소드를 사용하는 경우**
 *     - 입력 버퍼에 남아있는 개행 문자를 다음 nextLine 메소드가 읽어서 처리
 *     - 실제 입력값을 읽지 못함
 *     - 개행 문자 제거용 nextLine 메소드를 미리 호출해야 함
 */
public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주소 읽어오기
        System.out.println("주소 입력 : ");
        String address = sc.nextLine();

        System.out.println("> 입력한 주소는 [" + address + "]입니다.");
    }
}
