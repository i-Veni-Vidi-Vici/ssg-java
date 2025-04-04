package com.sh.method.scanner;

import java.util.Scanner;

/**
 * <pre>
 *   - next메소드 (nextInt, nextDouble, nextBoolean)
 *   - 공백, 개행문자 전까지 읽어서 반환
 *  next메소드 다음에 nextLine 메소드를 사용하는 경우
 *  - 입력버퍼에 남아있는 개행문자를 다음 nextLine메소드가 읽어서 처리하게 된다. 실제 입력값을 읽지 못함.
 *  - 개행문자를 제거용 nextLine메소드를 미리 호출해야 한다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //1. next 메소드 미리 사용
        System.out.print("이름 입력 : ");
        String name = scan.next();

        scan.nextLine(); // 입력버퍼의 개행문자 제거용
        //2. nextLine 메소드 사용
        System.out.println("자기소개 입력 : ");
        String greeting = scan.nextLine();

        System.out.println("이름 : " + name +   greeting);

    }
}
