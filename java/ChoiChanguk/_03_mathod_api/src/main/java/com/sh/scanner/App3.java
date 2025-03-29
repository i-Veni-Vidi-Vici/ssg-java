package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 * next메소드 다음에 nextLine메소드를 사용하는 경우
 * - 입력 버퍼에 남아 있는 개행문자를 다음 nextLineㅁ소드가 읽어서 처리하게 됨
 * - 실제 입력값을 읽지 못하는 상태가 된다.
 * - 개행문자 제거용 nextLine메소드를 미리 호출해야 한다.
 *
 * - next메소드 ( nextInt, nextDouble, nextBoolean)
 * - 공백, 개행문자 전까지 읽어서 반환
 * ex)이름을 입력합니다 -> "이름을" 반환 -> 입력합니다 는 입력 버퍼에 아직 남아 있음
 * - nextLine메소드
 * - 개행문자까지 읽어서 개행문자 제거 후 반환
 * ex)이름을 입력합니다 -> "이름을 입력합니다" 반환
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. next(nextInt, double, ~ 포합)메소드 사용
        System.out.print("이름 입력하세요 : ");
        String name= sc.next();

        //sc.nextLine();// 개행문자 제거용

        //2. nextLine메소드 사용
        System.out.print("자기소개 입력 : ");
        String greeting = sc.nextLine();

        System.out.println(" 이름 : "+name);
        System.out.println(" 자기소개 : "+greeting);
    }
}
