package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 *     - next 메소드 (nextInt, nextDouble, nextBoolean)
 *     - 공백, 개행문자 전까지 읽어서 반환
 *     - 이후 공백/개행문자는 입력 버퍼에 남아있음
 *     - nextLine 메소드
 *     - 개행문자까지 포함하여 읽어서 개행문자 제거 후 반환
 *
 *     - next메소드 다음에 nextLine메소드를 사용하는 경우
 *     - 입력 버퍼에 남아있는 개행문자를 다음 nextLine메소드가 읽어서 처리
 *     - 그러므로 실제 입력값을 읽지 못함
 *     - 개행문자 제거용 nextLine메소드를 미리 호출해야 함
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. next 메소드 사용
        System.out.print("> 이름 입력 : ");         // 개행 없이 입력
        String name = sc.next();

        // 입력버퍼의 개행문자 제거용
        // 없다면 입력 버퍼에 남아있는 개행문자를 읽어서 사용자가 입력할 수 없음, "" 자기소개에서 빈 문자열이 출력됨
        // next가 아닌 nextInt를 써도 똑같은 문제가 발생함
        sc. nextLine();

        // 2. nextLine 메소드 사용
        System.out.print("> 자기소개 입력 : ");
        String greeting = sc.nextLine();

        System.out.println("> 이름 : " + name);
        System.out.println("> 자기소개 : " + greeting);

    }
}
