package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 *     next 메소드 다음에 nextLine메소드를 사용하는 경우
 *     - 입력 버퍼에 남아있는 개행 문자를 다음 nextLine 메소드가 읽어서 처리
 *     - 개행문자 제거용 nextLine메소드를 미리 호출해야한다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 1. next 메소드 사용
        System.out.print("> 이름 입력 : ");
        String name = sc.next();

        System.out.println("> 자기소개 입력 : ");
        String greeting = sc.nextLine();

        System.out.println("> 이름 : " + name);
        System.out.println("> 자기소개 : " + greeting);
    }
}
