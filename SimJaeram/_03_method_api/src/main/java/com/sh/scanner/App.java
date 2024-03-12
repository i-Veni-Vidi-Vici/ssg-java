package com.sh.scanner;

import java.util.Scanner;

/**
 * <pre>
 *     java.util.Scanner 클래스 API
 *     - 사용자 표준입력(키보드 입력)을 읽어들이는 기능 제공
 *     - 사용자 입력을 토큰 단위(공백, 개행문자 등으로 구분된 문자열)로 분리해서 읽어들인다.
 *     - 문자열, 정수, 실수, 논리값 등으로 변환하여 리턴하는 메소드 제공
 *
 *     표준 입력 // 키보드
 *     - System.in
 *     표준 출력 // 콘솔
 *     - System.out
 *
 *     구분
 *     - next 계열 메소드
 *     - nextInt()
 *     - nextBoolean()
 *     - next()
 *
 *     - nextLine() 계열 메소드
 *     - nextLine()
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성, Scanner 클래스 사용하기 위해 import 필요
        Scanner sc = new Scanner(System.in);            // 표준 입력을 읽어들이는 Scanner 객체 생성

        // 2. 문자열 String 입력값 읽어오기
        System.out.print("이름 입력 : ");
        String name = sc.next();
        System.out.println("> 입력한 이름은 " + name + "입니다.");

        // 3. 정수 int 입력 값 읽어오기
        System.out.print("나이 입력: ");
        int age = sc.nextInt();
        System.out.println("> 입력한 나이는 " + age + "세 입니다.");
    }
}
